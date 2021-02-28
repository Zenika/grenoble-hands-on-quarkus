package com.zenika.handson.quarkus

import com.zenika.handson.quarkus.repositories.CitiesRepositoryJpa
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import uk.co.datumedge.hamcrest.json.SameJSONAs.sameJSONAs
import javax.inject.Inject
import javax.transaction.Transactional


@QuarkusTest
class WeatherControllerTest {

    @Inject
    lateinit var citiesRepositoryJpa: CitiesRepositoryJpa

    @BeforeEach
    @Transactional
    fun setup() {
        initData(citiesRepositoryJpa)
    }

    @Test
    fun `get weather for grenoble return 200`() {
        given()
            .`when`()
            .get("/cities/GRENOBLE/weather")
            .then()
            .statusCode(200)
            .body(sameJSONAs(javaClass.getResource("/contract/weather/GET_DAILY_WEATHER.json").readText()))
    }

    @Test
    fun `get weather for unknown return 404`() {
        given()
            .`when`()
            .get("/cities/UNKNOWN/weather")
            .then()
            .statusCode(404)
    }
}
