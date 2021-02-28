package com.zenika.handson.quarkus.entities

import io.quarkus.hibernate.orm.panache.kotlin.PanacheEntityBase
import org.hibernate.validator.constraints.Length
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Entity
class City(name: String, position: GeoPosition): PanacheEntityBase {
    constructor() : this("", GeoPosition()) {}
    @Id
    @field:NotBlank
    @field:Length(min = 2)
    var name: String = name

    @Embedded
    @field:Valid
    var position: GeoPosition = position

}