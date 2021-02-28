package com.zenika.handson.quarkus.repositories.http

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class Weather7TimerMapperTest {

    @Test
    fun `convert daily weather from 7timer to domain`() {
        // Given
        val weather7Timer = DailyWeather7Timer(listOf(DailyWeather7Timer.DataSeries("20210223", DailyWeather7Timer.Temp2m(28.0, 27.0), "lightrain", 3.0)))

        // When
        val dailyWeather = Weather7TimerMapper.toDomain(weather7Timer)[0]

        // Then
        Assertions.assertEquals(dailyWeather.day, LocalDate.of(2021, 2, 23))
        Assertions.assertEquals(dailyWeather.temperatureMax, 28.0)
        Assertions.assertEquals(dailyWeather.temperatureMin, 27.0)
        Assertions.assertEquals(dailyWeather.weather, "lightrain")
    }
}
