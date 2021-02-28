package com.zenika.handson.quarkus

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.GeoPosition
import com.zenika.handson.quarkus.repositories.CitiesRepositoryJpa
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs
import javax.inject.Inject
import javax.transaction.Transactional


@QuarkusTest
class CitiesControllerTest {

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
}
