plugins {
    id("org.jetbrains.kotlin.jvm") version("1.3.21") apply(false)
    application
}

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        jcenter()
    }

    dependencies {
        implementation(kotlin("stdlib", "1.3.21"))
        testImplementation("junit:junit:4.12")
    }

}