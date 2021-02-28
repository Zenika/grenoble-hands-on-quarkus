package com.zenika.handson.quarkus.entities

import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class City(
    @Id
    var name: String,
    @Embedded
    var position: GeoPosition
)
