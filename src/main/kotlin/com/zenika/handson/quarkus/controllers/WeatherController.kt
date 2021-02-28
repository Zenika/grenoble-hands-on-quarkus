package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.services.WeatherService
import io.quarkus.cache.CacheResult
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.core.Response

@Path("/cities")
class WeatherController(private val weatherService: WeatherService) {

    @GET
    @Path("/{name}/weather")
    @CacheResult(cacheName = "weather")
    fun getDailyWeather(@PathParam("name") name: String): Response = weatherService.getDailyWeatherForCity(name)
        ?.let { Response.ok(it).build() }
        ?: Response.status(404).build()

}
