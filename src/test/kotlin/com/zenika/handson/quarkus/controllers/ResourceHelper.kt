package com.zenika.handson.quarkus.controllers

class ResourceHelper {
    companion object {
        fun getResource(resource: String): String = javaClass.classLoader.getResource(resource).readText()
    }
}
