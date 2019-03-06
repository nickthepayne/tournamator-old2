plugins {
    kotlin("jvm") version "1.3.21"
}

allprojects {

    pluginManager.withPlugin("org.jetbrains.kotlin.jvm") {
        tasks.compileKotlin {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    repositories {
        jcenter()
    }
}