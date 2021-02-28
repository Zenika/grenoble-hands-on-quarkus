package com.zenika.handson.quarkus.repositories.jpa

import com.zenika.handson.quarkus.entities.City
import com.zenika.handson.quarkus.repositories.CitiesRepository
import io.quarkus.hibernate.orm.panache.kotlin.PanacheRepository
import javax.enterprise.context.ApplicationScoped
import javax.transaction.Transactional

@ApplicationScoped
class CitiesRepositoryJpa: PanacheRepository<City>, CitiesRepository {
    override fun getByName(name: String): City? = find("name",name).firstResult()
    override fun findAllCities():List<City> = findAll().list()
    @Transactional
    override fun save(city: City) = persist(city)
}