plugins {
    id("java")
    id("org.hibernate.orm") version "6.4.0.Final"
    id("io.freefair.lombok") version "8.4"
    id("org.springframework.boot") version "3.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.hibernate:hibernate-core:5.5.7.Final")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.opencsv:opencsv:5.5.2")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("mysql:mysql-connector-java:8.0.26")
    implementation("jakarta.persistence:jakarta.persistence-api:3.0.0")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation(platform("org.springframework.boot:spring-boot-dependencies:2.7.8"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}

tasks.test {
    useJUnitPlatform()
}