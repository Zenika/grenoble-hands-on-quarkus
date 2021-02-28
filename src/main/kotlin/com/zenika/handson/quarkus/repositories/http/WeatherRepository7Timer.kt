package com.zenika.handson.quarkus.repositories.http

import com.fasterxml.jackson.databind.ObjectMapper
import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.Weather
import com.zenika.handson.quarkus.repositories.WeatherRepository
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherRepository7Timer(@RestClient val restClient7Timer: RestClient7Timer, val objectMapper: ObjectMapper) : WeatherRepository {

    override fun getDailyWeather(city: City): List<Weather> {
        return restClient7Timer.getWeather(city.position.longitude, city.position.latitude)
            .let { objectMapper.readValue(it, DailyWeather7Timer::class.java) }
            .let { Weather7TimerMapper.toDomain(it) }
    }
}
