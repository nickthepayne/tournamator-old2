plugins {
    kotlin("jvm") version "1.3.21" apply false
}

tasks.register("buildProd") {
    // build-web && build-app
    // copy-web

    // start
}

tasks.register<Copy>("copyWeb") {
    from("tournamator-web/build")
    into("tournamator-app/build/classes/kotlin/main/public")
}

tasks.getByName("buildProd")
    .dependsOn("copyWeb")
    .dependsOn(":tournamator-web:build")

allprojects {

    repositories {
        jcenter()
    }
}