package com.zenika.handson.quarkus.repositories.http

import com.zenika.handson.quarkus.entities.Weather
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Weather7TimerMapper {

    companion object {

        fun toDomain(dailyWeather7Timer: DailyWeather7Timer): List<Weather> {
            return dailyWeather7Timer.dataseries.map {
                Weather(
                    day = LocalDate.parse(it.date, DateTimeFormatter.ofPattern("yyyyMMdd")),
                    weather = it.weather,
                    temperatureMax = it.temp2m.max,
                    temperatureMin = it.temp2m.min
                )
            }
        }

    }
}
