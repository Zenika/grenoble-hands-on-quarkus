package com.zenika.handson.quarkus.entities

import java.time.LocalDate

data class Weather(val day: LocalDate, val weather: String, val temperatureMax: Double, val temperatureMin: Double)
