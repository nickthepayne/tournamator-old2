plugins {
    kotlin("jvm") version "1.3.21"
    id("org.jetbrains.kotlin.plugin.spring") version "1.3.21" apply false
    id("org.springframework.boot") version "2.1.3.RELEASE" apply false
    id("io.spring.dependency-management") version "1.0.7.RELEASE" apply false
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

subprojects {

    if (!name.equals("tournamator-web")) {
        apply(plugin = "org.jetbrains.kotlin.jvm")
        apply(plugin = "org.jetbrains.kotlin.plugin.spring")
        apply(plugin = "org.springframework.boot")
        apply(plugin = "io.spring.dependency-management")
        
        dependencies {
            compile(kotlin("stdlib"))
            testImplementation("org.junit.jupiter:junit-jupiter:5.4.0")
        }
    }

}