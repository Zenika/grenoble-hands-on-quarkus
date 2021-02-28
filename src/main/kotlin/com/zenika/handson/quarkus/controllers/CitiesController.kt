package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.CitiesRepository
import javax.annotation.security.RolesAllowed
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cities")
class CitiesController(@Inject private val citiesRepository: CitiesRepository) {

    @GET
    fun findAll(): List<City> = citiesRepository.findAllCities()

    @GET
    @Path("/{name}")
    fun findByName(@PathParam("name") name: String): Response =
        citiesRepository.getByName(name)
            ?.let { Response.ok(it).build() }
            ?: Response.status(Response.Status.NOT_FOUND).build()

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("admin")
    fun saveCity(@Valid city: City): Response {
        citiesRepository.save(city)
        return Response.status(Response.Status.CREATED).entity(city).build()
    }
}