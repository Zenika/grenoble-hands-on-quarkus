package com.zenika.handson.quarkus

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.GeoPosition
import com.zenika.handson.quarkus.repositories.CitiesRepositoryJpa
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs
import javax.inject.Inject
import javax.transaction.Transactional


@QuarkusTest
@Transactional
class CitiesControllerTest {

    @Inject
    lateinit var citiesRepositoryJpa: CitiesRepositoryJpa

    @BeforeEach
    @Transactional
    fun setup() {
        initData(citiesRepositoryJpa)
    }

    @Test
    fun `get all cities return 200`() {
        given()
            .`when`()
            .get("/cities")
            .then()
            .statusCode(200)
            .body(sameJSONAs(javaClass.getResource("/contract/cities/GET_CITIES.json").readText()))
    }

    @Test
    fun `get known city return 200`() {
        given()
            .`when`()
            .get("/cities/GRENOBLE")
            .then()
            .statusCode(200)
            .body(sameJSONAs(javaClass.getResource("/contract/cities/GET_CITY.json").readText()))
    }

    @Test
    fun `get unknown city return 404`() {
        given()
            .`when`()
            .get("/cities/UNKNOWN")
            .then()
            .statusCode(404)
    }


    @Test
    fun `add new city return 201`() {
        given()
            .contentType(ContentType.JSON)
            .body(javaClass.getResource("/contract/cities/POST_CITY.json").readText())
            .`when`()
            .post("/cities")
            .then()
            .statusCode(200)
            .body(sameJSONAs(javaClass.getResource("/contract/cities/POST_CITY.json").readText()))
    }

    @Test
    fun `add invalid city return 400`() {
        given()
            .contentType(ContentType.JSON)
            .body(javaClass.getResource("/contract/cities/POST_INVALID_CITY.json").readText())
            .`when`()
            .post("/cities")
            .then()
            .statusCode(400)
    }
}
