package com.zenika.handson.quarkus.repositories

import com.zenika.handson.quarkus.entities.City
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
class CitiesRepositoryJpa : CitiesRepository, PanacheRepository<City> {
    override fun getAll(): List<City> {
        return listAll()
    }

    override fun getByName(name: String): City? {
        return find("name", name).firstResult()
    }
}
