package com.zenika.handson.quarkus.services

import com.zenika.handson.quarkus.repositories.CitiesRepository
import com.zenika.handson.quarkus.repositories.WeatherRepository
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class WeatherService(private val cityRepository: CitiesRepository, private val weatherRepository: WeatherRepository) {

    fun getDailyWeatherForCity(name: String) = cityRepository.getByName(name)
        ?.let { weatherRepository.getDailyWeather(it) }

}
