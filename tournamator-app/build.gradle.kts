import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    application
}

application {
    mainClassName = "ch.tournamator.AppKt"
}

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.jetbrains.kotlin:kotlin-reflect:1.3.21")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.+")
    compile("com.google.appengine:appengine-api-1.0-sdk:1.9.71")
    compile(project(":tournamator-data"))
}

tasks.register("buildDeployableJar") {
    dependsOn("bootJar")
}

tasks.bootJar {
    dependsOn(":tournamator-web:build")
}

tasks.getByName<BootJar>("bootJar") {

    from("../tournamator-web/build") {
        into("public")
    }

}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}
