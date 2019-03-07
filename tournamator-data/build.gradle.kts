import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    compile("org.springframework.boot:spring-boot-starter-data-mongodb")
}

tasks.withType<Jar> {
    enabled = true
}

tasks.withType<BootJar> {
    enabled = false
}
