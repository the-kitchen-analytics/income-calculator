plugins {
    id("java")
    id("org.springframework.boot") version "3.3.2" apply false
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.thekitchen.incomecalculator"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:firebase-starter:firebase-core"))
    implementation(libs.spring.boot.autoconfigure)
    implementation(libs.firebase.admin)
}

tasks.test {
    useJUnitPlatform()
}
