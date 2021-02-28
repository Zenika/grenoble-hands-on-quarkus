package com.zenika.handson.quarkus.repositories.http

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class DailyWeather7Timer(val dataseries: List<DataSeries>) {
    constructor() : this(listOf())
    data class DataSeries(val date: String, val temp2m: Temp2m, val weather: String, val wind10m_max: Double) {
        constructor(): this("", Temp2m(),"",0.0)
    }
    data class Temp2m(val max: Double, val min: Double){
        constructor(): this(0.0, 0.0)
    }
}
