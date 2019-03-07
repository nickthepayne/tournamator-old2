package ch.tournamator

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
class App

fun main(args: Array<String>) {
    runApplication<App>(*args)
}

@Bean
fun objectMapper(): ObjectMapper {
    val objectMapper = ObjectMapper()
    objectMapper.registerModule(KotlinModule())
    return objectMapper
}

