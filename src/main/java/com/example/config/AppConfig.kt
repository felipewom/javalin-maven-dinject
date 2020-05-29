@file:JvmName("AppConfig")

package com.example.config

import java.io.FileInputStream
import java.util.*


object AppConfig {

    @JvmStatic
    var appProperties: Properties

    init {
        appProperties = getProperties()
    }

    @JvmStatic
    fun getProperty(key: String, defaultValue: Any? = null): Any? = appProperties.getOrDefault(key, defaultValue)

    private fun getProperties(): Properties {
        val appProps = getPropertyMap("application.properties")
        val devProps = getPropertyMap("application-dev.properties")
        val merged = Properties()
        merged.putAll(appProps)
        merged.putAll(devProps)
        return merged
    }

    private fun getPropertyMap(propFileName: String): Properties {
        val props = Properties()
        val configPath = Thread.currentThread().contextClassLoader.getResource(propFileName) ?: return props
        props.load(FileInputStream(configPath.path))
        return props
    }
}