package ch.tournamator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.google.appengine.api.datastore.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class App

fun main(args: Array<String>) {

    val profile = System.getProperty("spring.profiles.active")

    if (profile == "prod") {
        setEnvironmentPropertiesOffGae()
    }

    runApplication<App>(*args)
}

fun setEnvironmentPropertiesOffGae() {
    val datastoreService = DatastoreServiceFactory.getDatastoreService()

    val q = Query("settings")

    println("Looking for mongodb URI...")

    val mongodbUri: Entity = datastoreService.prepare(q).asIterable()
        .find { it.getProperty("GCLOUD_MONGODB_URI") != null } ?: return

    println("Found mongodb URI...")

    val property = mongodbUri.getProperty("MONGODB_URI")
    System.setProperty("MONGODB_URI", property.toString())
}

@Bean
fun objectMapper(): ObjectMapper {
    val objectMapper = ObjectMapper()
    objectMapper.registerModule(KotlinModule())
    return objectMapper
}

