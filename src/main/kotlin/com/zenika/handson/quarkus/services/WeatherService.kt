package com.zenika.handson.quarkus.services

import com.zenika.handson.quarkus.entities.Weather
import com.zenika.handson.quarkus.repositories.CitiesRepository
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherService(private val cityRepository: CitiesRepository) {

    fun getDailyWeatherForCity(name: String) = cityRepository.getByName(name)
        ?.let { listOf(Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)) }

}
