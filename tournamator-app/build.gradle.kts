plugins {
    application
    kotlin("jvm")
    id("org.hidetake.appengine.spring.boot") version "1.1"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21"
    id("org.springframework.boot") version "2.1.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.7.RELEASE"
    
}

// compile group: 'com.google.appengine', name: 'gradle-appengine-plugin', version: '1.9.59'

application {
    mainClassName = "ch.tournamator.App"
}

appengine {
    deploy {
        stopPreviousVersion = true
        promote = true
    }
}

dependencies {
    compile(kotlin("stdlib"))
    compile("com.google.appengine:appengine-api-1.0-sdk:+")
    compile("org.springframework.boot:spring-boot-starter-web", { exclude("org.springframework.boot", "spring-boot-starter-tomcat")})
    compile("javax.servlet:javax.servlet-api:4.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.register("buildProd") {
    // build-web && build-app
    // copy-web

    // start
}

tasks.war {
    enabled = true
    from("../tournamator-web/build")
}

tasks.getByName("war")
    .dependsOn("buildProd")

tasks.getByName("buildProd")
    .dependsOn(":tournamator-web:build")
