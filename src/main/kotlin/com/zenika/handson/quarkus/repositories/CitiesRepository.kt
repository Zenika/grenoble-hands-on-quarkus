package com.zenika.handson.quarkus.repositories

import com.zenika.handson.quarkus.entities.City

interface CitiesRepository {
    fun getByName(name: String): City?
    fun findAllCities(): List<City>
    fun save(city: City)
}