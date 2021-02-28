package com.zenika.handson.quarkus.repositories

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.Weather

interface WeatherRepository {
    fun getDailyWeather(city: City): List<Weather>
}
