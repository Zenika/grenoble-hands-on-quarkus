package com.zenika.handson.quarkus

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.jpa.CitiesRepositoryJpa
import com.zenika.handson.quarkus.entities.GeoPosition
import io.quarkus.runtime.ShutdownEvent

import javax.enterprise.event.Observes

import io.quarkus.runtime.StartupEvent
import java.util.logging.Logger

import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional


@ApplicationScoped
class AppLifecycleBean(private val citiesRepositoryJpa: CitiesRepositoryJpa) {
    @Transactional
    fun onStart(@Observes ev: StartupEvent?) {
        LOGGER.info("The application is starting...")
        citiesRepositoryJpa.persist(listOf(
            City("GRENOBLE", GeoPosition(45.183916, 5.703630)),
                City("SINGAPOUR", GeoPosition(1.295600, 103.858995)),
                City("BORDEAUX", GeoPosition(44.848089, -0.571017)),
                City("BREST", GeoPosition(48.389397, -4.499237)),
                City("MONTREAL", GeoPosition(45.523000, -73.581700)),
                City("LYON", GeoPosition(45.767443, 4.858798)),
                City("RENNES", GeoPosition(48.113409, -1.661249)),
                City("NANTES", GeoPosition(47.207408, -1.556187)),
                City("LILLE", GeoPosition(50.648670, 3.075520)),
                City("PARIS", GeoPosition(48.878932, 2.328487))),
        )
    }

    fun onStop(@Observes ev: ShutdownEvent?) {
        LOGGER.info("The application is stopping...")
    }

    companion object {
        private val LOGGER: Logger = Logger.getLogger("ListenerBean")
    }
}