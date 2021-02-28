package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.controllers.ResourceHelper.Companion.getResource
import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.`when`
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert

@QuarkusTest
class WeatherControllerTest {

    @Test
    fun `get weather for known city return 200`() {
        val content = `when`()
            .get("/cities/GRENOBLE/weather")
            .then()
            .assertThat()
            .statusCode(200)
            .and().extract().body().asString()
        JSONAssert.assertEquals(content, getResource("/contract/weather/GET_DAILY_WEATHER.json"), false)

    }
    @Test
    fun `get weather for unknown city return 404`() {
        val content = `when`()
            .get("/cities/NOWHERE/weather")
            .then()
            .assertThat()
            .statusCode(404)
    }

}