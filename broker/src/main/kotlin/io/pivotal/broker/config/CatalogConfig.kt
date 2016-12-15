package io.pivotal.broker.config

import org.springframework.cloud.servicebroker.model.Catalog
import org.springframework.cloud.servicebroker.model.Plan
import org.springframework.cloud.servicebroker.model.ServiceDefinition
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

@Configuration
open class CatalogConfig {

    @Bean
    open fun catalog(): Catalog {
        return Catalog(Collections.singletonList(
                ServiceDefinition(
                        "simple-hive",
                        "simple-hive",
                        "A simple Hive service",
                        true,
                        false,
                        listOf(
                                Plan(
                                        "simple-hive-plan",
                                        "default",
                                        "This is the default plan.",
                                        getPlanMetadata(),
                                        true)),
                        listOf("hive"),
                        getServiceDefinitionMetadata(),
                        null,
                        null))
        )
    }

    private fun getServiceDefinitionMetadata() = mapOf(
            "displayName" to "Simple Hive",
            "longDescription" to "A simple Hive service",
            "providerDisplayName" to "Pivotal",
            "documentationUrl" to "https://github.com/pivotal/simple-hive",
            "supportUrl" to "https://github.com/pivotal/simple-hive",
            "imageUrl" to "https://docs.google.com/drawings/d/1oxi8BlLNEbHX0-vTDHRrdu1fgh55Q7FkP8uq66YA51A/pub?w=960&h=720")

    private fun getPlanMetadata() = mapOf(
            "costs" to getCosts(),
            "bullets" to getBullets())

    private fun getCosts() = listOf(mapOf(
            "unit" to "MONTHLY",
            "amount" to mapOf("usd" to 0)))

    private fun getBullets() = listOf(
            "Shared Simple Hive Server",
            "Stores data in locally (container)",
            "Data to be considered volatile")
}