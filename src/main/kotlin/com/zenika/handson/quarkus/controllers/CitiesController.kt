package com.zenika.handson.quarkus.controllers

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.GeoPosition
import io.netty.handler.codec.http.HttpResponseStatus
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/cities")
class CitiesController {

    private val cities = listOf(
        City("GRENOBLE", GeoPosition(45.183916, 5.703630)),
        City("LYON", GeoPosition(45.767443, 4.858798)),
    )

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun cities() = cities

    @GET
    @Path("/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    fun city(@PathParam("city") city: String): Response = cities
        .find { it.name == city }
        ?.let { Response.ok(it).build() }
        ?: Response.status(Response.Status.NOT_FOUND).build()
}
