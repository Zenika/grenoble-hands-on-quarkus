package com.zenika.handson.quarkus.repositories.inmemory

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.WeatherRepository
import com.zenika.handson.quarkus.entities.Weather
import io.quarkus.test.Mock
import java.time.LocalDate
import javax.enterprise.context.ApplicationScoped


@Mock
@ApplicationScoped
class WeatherRepositoryInMemory : WeatherRepository {

    override fun getDailyWeather(city: City): List<Weather> {
        return listOf(
            Weather(LocalDate.of(2021, 2, 23), "cloudy", 28.0, 27.0)
        )
    }
}
