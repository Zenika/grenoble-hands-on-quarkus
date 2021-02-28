package com.zenika.handson.quarkus

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.entities.GeoPosition
import com.zenika.handson.quarkus.repositories.CitiesRepositoryJpa

fun initData(citiesRepositoryJpa: CitiesRepositoryJpa) {
    citiesRepositoryJpa.deleteAll()
    citiesRepositoryJpa.persist(
        City("GRENOBLE", GeoPosition(45.183916, 5.703630)),
        City("LYON", GeoPosition(45.767443, 4.858798)),
    )

}