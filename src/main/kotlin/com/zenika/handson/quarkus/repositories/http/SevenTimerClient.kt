package com.zenika.handson.quarkus.repositories.http

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.GET
import javax.ws.rs.Produces
import javax.ws.rs.QueryParam

@RegisterRestClient(configKey = "seventimer")
interface SevenTimerClient {
    @GET
    @Produces("text/plain")
    fun getWeathers(
        @QueryParam("lat")
        latitude: Double,
        @QueryParam("lon")
        longitude: Double,
    ): String
}