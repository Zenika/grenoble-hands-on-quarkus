package com.zenika.handson.quarkus.entities

import javax.persistence.Embeddable

@Embeddable
data class GeoPosition(
    var latitude: Double,
    var longitude: Double
)
