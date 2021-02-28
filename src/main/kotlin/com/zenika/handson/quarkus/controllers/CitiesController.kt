package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.repositories.CitiesRepository
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cities")
class CitiesController(private val citiesRepository: CitiesRepository) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun cities() = citiesRepository.getAll()

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    fun city(@PathParam("city") city: String): Response = citiesRepository.getByName(city)
        ?.let { Response.ok(it).build() }
        ?: Response.status(Response.Status.NOT_FOUND).build()
}
