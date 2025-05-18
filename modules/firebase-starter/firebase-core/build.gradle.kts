plugins {
    id("java")
}

group = "com.thekitchen.incomecalculator"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.firebase.admin)
    testImplementation(platform("org.junit:junit-bom:5.10.3"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.3")
    testImplementation("org.assertj:assertj-core:3.26.3")
}

tasks.test {
    useJUnitPlatform()
}
