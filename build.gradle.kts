plugins {
    kotlin("jvm") version "1.3.21"
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib", "1.3.21"))
    testImplementation("junit:junit:4.12")
}

application {
    mainClassName = "ch.tournamator.AppKt"
}
