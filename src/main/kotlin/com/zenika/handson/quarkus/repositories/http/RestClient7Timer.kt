package com.zenika.handson.quarkus.repositories.http

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@RegisterRestClient(configKey = "seventimer")
interface RestClient7Timer {

    @GET
    @Produces("text/plain")
    fun getWeather(@QueryParam("lon") longitude: Double, @QueryParam("lat") latitude: Double): String
}
