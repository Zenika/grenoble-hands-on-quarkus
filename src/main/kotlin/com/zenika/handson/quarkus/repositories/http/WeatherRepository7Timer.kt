package com.zenika.handson.quarkus.repositories.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.WeatherRepository
import com.zenika.handson.quarkus.entities.Weather
import com.zenika.handson.quarkus.repositories.http.Weather7TimerMapper.Companion.toDomain
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherRepository7Timer(
    @RestClient private val sevenTimerClient: SevenTimerClient,
    private val objectMapper: ObjectMapper
) : WeatherRepository {

    override fun getDailyWeather(city: City): List<Weather> {
        val weathers = sevenTimerClient.getWeathers(city.position.latitude, city.position.longitude)
        return toDomain(
            objectMapper.readValue(
                weathers,
                DailyWeather7Timer::class.java
            )
        )
    }
}
