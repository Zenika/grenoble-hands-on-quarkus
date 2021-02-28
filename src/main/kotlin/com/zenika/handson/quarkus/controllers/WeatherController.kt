package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.entities.Weather
import com.zenika.handson.quarkus.repositories.CitiesRepository
import java.time.LocalDate
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cities")
class WeatherController(private val cityRepository: CitiesRepository) {

    @GET
    @Path("/{city}/weather")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCityWeather(@PathParam("city") city: String): Response = cityRepository.getByName(city)
        ?.let { listOf(Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)) }
        ?.let { Response.ok(it).build() }
        ?: Response.status(Response.Status.NOT_FOUND).build()

}
