plugins {
    id("java")
}

group = "com.thekitchen.incomecalculator"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":modules:model"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
