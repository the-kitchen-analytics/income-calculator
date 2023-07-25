plugins {
  java
  id("org.springframework.boot") version "3.1.1"
  id("io.spring.dependency-management") version "1.1.0"
  kotlin("jvm") version "1.9.0"
  kotlin("kapt") version "1.9.0"
  kotlin("plugin.lombok") version "1.9.0"
}

group = "com.thekitchen"
version = "0.0.2"

java {
  sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
  compileOnly {
    extendsFrom(configurations.annotationProcessor.get())
  }
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  compileOnly("org.projectlombok:lombok")
  annotationProcessor("org.projectlombok:lombok")
  testImplementation("org.springframework.boot:spring-boot-starter-test")

  // Custom dependencies
  val firebaseVersion = "9.2.0"
  val mapstructVersion = "1.5.5.Final"
  implementation("org.projectlombok:lombok-mapstruct-binding:0.2.0")
  implementation("com.google.firebase:firebase-admin:$firebaseVersion")
  implementation("org.mapstruct:mapstruct:${mapstructVersion}")
  kapt("org.mapstruct:mapstruct-processor:${mapstructVersion}")

  testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
  testImplementation("org.assertj:assertj-core:3.11.1")
}


kapt {
  keepJavacAnnotationProcessors = true
  arguments {
    // Set Mapstruct Configuration options here
    // https://kotlinlang.org/docs/reference/kapt.html#annotation-processor-arguments
    // https://mapstruct.org/documentation/stable/reference/html/#configuration-options
    arg("mapstruct.defaultComponentModel", "spring")
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
