package com.zenika.handson.quarkus.entities

import javax.persistence.Embeddable
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Embeddable
class GeoPosition(latitude: Double, longitude: Double){
    constructor() : this(0.0,0.0) {
    }

    @field:Min(-90) @field:Max(90)
    var latitude: Double =latitude

    @field:Min(-180) @field:Max(180)
    var longitude: Double=longitude
}