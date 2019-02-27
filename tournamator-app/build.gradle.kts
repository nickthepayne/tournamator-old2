plugins {
    application
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
}

application {
    mainClassName = "ch.tournamator.AppKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("org.springframework.boot:spring-boot-starter-web")
}
