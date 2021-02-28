package com.zenika.handson.quarkus.repositories

import com.zenika.handson.quarkus.entities.City

interface CitiesRepository {
    fun getAll(): List<City>
    fun getByName(name: String): City?
}
