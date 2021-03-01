package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.CitiesRepository
import javax.annotation.security.RolesAllowed
import javax.validation.Valid
import javax.ws.rs.*
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("ADMIN")
    fun create(@Valid city: City) = citiesRepository.save(city)
}
