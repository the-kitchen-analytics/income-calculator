plugins {
  java
  id("org.springframework.boot") version "3.3.2"
  id("io.spring.dependency-management") version "1.1.6"
  kotlin("jvm") version "2.0.10"
  kotlin("kapt") version "2.0.10"
  kotlin("plugin.lombok") version "2.0.10"
}

group = "com.thekitchen"

java {
  sourceCompatibility = JavaVersion.VERSION_21
  targetCompatibility = JavaVersion.VERSION_21
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

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  compileOnly("org.projectlombok:lombok")
  testCompileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testAnnotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  // Custom dependencies
  val mapstructVersion = "1.6.0"
  implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
  implementation("com.google.firebase:firebase-admin:9.3.0")
  implementation("org.mapstruct:mapstruct:${mapstructVersion}")
  implementation("com.github.java-json-tools:json-patch:1.13")
  kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")

  testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
  testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

configurations {
  runtimeOnly {
    exclude(group = "commons-logging", module = "commons-logging")
  }
}
