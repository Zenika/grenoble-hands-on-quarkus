package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.services.WeatherService
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cities")
class WeatherController(private val weatherService: WeatherService) {

    @GET
    @Path("/{city}/weather")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCityWeather(@PathParam("city") city: String): Response = weatherService.getDailyWeatherForCity(city)
        ?.let { Response.ok(it).build() }
        ?: Response.status(Response.Status.NOT_FOUND).build()

}
