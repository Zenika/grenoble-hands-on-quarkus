package com.zenika.handson.quarkus.entities

import org.hibernate.validator.constraints.Length
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.Valid
import javax.validation.constraints.NotBlank

@Entity
data class City(
    @Id
    @field:NotBlank @field:Length(min = 2)
    var name: String,

    @Embedded
    @field:Valid
    var position: GeoPosition
)
