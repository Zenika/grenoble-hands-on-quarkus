package com.zenika.handson.quarkus

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs


@QuarkusTest
class CitiesControllerTest {

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
