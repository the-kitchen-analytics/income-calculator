plugins {
    java
    kotlin("jvm") version "2.0.10"
    kotlin("kapt") version "2.0.10"
    kotlin("plugin.lombok") version "2.0.10"
    id("org.springframework.boot") version "3.3.2" apply false
    id("io.spring.dependency-management") version "1.1.6"
}

group = "com.thekitchen.incomecalculator"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    api(project(":modules:repository:api"))
    implementation("com.github.java-json-tools:json-patch:1.13")
    implementation(libs.spring.boot.autoconfigure)
    implementation(libs.firebase.admin)
    implementation(libs.lombok.mapstruct.binding)
    implementation(libs.mapstruct)
    implementation(project(":modules:model"))
    implementation(project(":modules:firebase-starter:firebase-core"))
    implementation(project(":modules:firebase-starter:firebase-spring-boot-starter"))
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)
    kapt(libs.mapstruct.processor)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testCompileOnly(libs.lombok)
    testAnnotationProcessor(libs.lombok)
}

tasks.test {
    useJUnitPlatform()
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
        kapt {
            keepJavacAnnotationProcessors = true
            arguments {
                // Set Mapstruct Configuration options here
                // https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
                // https://mapstruct.org/documentation/stable/reference/html/#configuration-options
                arg("mapstruct.defaultComponentModel", "spring")
            }
        }
    }
}
