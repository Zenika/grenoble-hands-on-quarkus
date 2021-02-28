package com.zenika.handson.quarkus.repositories.http

data class DailyWeather7Timer(val dataseries: List<DataSeries>) {
    data class DataSeries(val date: String, val temp2m: Temp2m, val weather: String, val wind10m_max: Double)
    data class Temp2m(val max: Double, val min: Double)
}
