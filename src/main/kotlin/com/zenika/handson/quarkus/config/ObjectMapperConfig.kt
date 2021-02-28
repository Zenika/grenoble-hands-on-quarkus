package com.zenika.handson.quarkus.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.quarkus.jackson.ObjectMapperCustomizer
import javax.inject.Singleton

@Singleton
class ObjectMapperConfig: ObjectMapperCustomizer {

    override fun customize(objectMapper: ObjectMapper?) {
        objectMapper
            ?.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
    }

}
