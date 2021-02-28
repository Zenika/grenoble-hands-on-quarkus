package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.controllers.ResourceHelper.Companion.getResource
import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.jpa.CitiesRepositoryJpa
import com.zenika.handson.quarkus.entities.GeoPosition
import io.quarkus.test.junit.QuarkusTest
import io.quarkus.test.security.TestSecurity
import io.restassured.RestAssured.*
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import javax.inject.Inject
import javax.transaction.Transactional

@QuarkusTest
internal class CitiesControllerTest {

    @Inject
    lateinit var citiesRepositoryJpa: CitiesRepositoryJpa

    @BeforeEach
    @Transactional
    fun setup() {
        citiesRepositoryJpa.deleteAll()
        citiesRepositoryJpa.persist(
            City("GRENOBLE", GeoPosition(45.183916, 5.703630)),
            City("LYON", GeoPosition(45.767443, 4.858798)),
        )
    }

    @Test
    fun `get all cities return 200`() {
        val res = get("/cities")
            .then().assertThat()
            .statusCode(200)
            .extract().body().asString()
        JSONAssert.assertEquals(res, getResource("/contract/cities/GET_CITIES.json"), true)
    }

    @Test
    fun `get existing city return 200`() {
        val res =
            `when`()
                .get("/cities/GRENOBLE")
                .then().assertThat()
                .statusCode(200)
                .extract().body().asString()
        JSONAssert.assertEquals(res, getResource("/contract/cities/GET_CITY.json"), true)
    }

    @Test
    fun `get unknown city return 404`() {
        `when`()
            .get("/cities/NOWHERE")
            .then().assertThat()
            .statusCode(404)
    }

    @Test
    fun `add new city without login return 401`() {
        given()
            .contentType(ContentType.JSON)
            .body(getResource("/contract/cities/POST_CITY.json"))
            .`when`()
            .post("/cities")
            .then()
            .assertThat().statusCode(401)
    }

    @Test
    @TestSecurity(user = "admin", roles = ["admin"])
    fun `add new city return 201`() {
        val content = given()
            .contentType(ContentType.JSON)
            .body(getResource("/contract/cities/POST_CITY.json"))
            .`when`()
            .post("/cities")
            .then()
            .assertThat().statusCode(201)
            .extract().body().asString()
        JSONAssert.assertEquals(content, getResource("/contract/cities/POST_CITY.json"), true)
    }

    @Test
    @TestSecurity(user = "admin", roles = ["admin"])
    fun `add invalid city return 400`() {
        val content = given()
            .contentType(ContentType.JSON)
            .body(getResource("/contract/cities/POST_INVALID_CITY.json"))
            .post("/cities")
            .then()
            .assertThat().statusCode(400)
    }
}