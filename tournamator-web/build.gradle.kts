import com.moowork.gradle.node.npm.NpmTask

plugins {
    id("com.moowork.node") version "1.2.0"
}

node {
    download  = true
}

tasks.register<NpmTask>("build") {
    setArgs(listOf("run", "build"))

    dependsOn("npmInstall")
}