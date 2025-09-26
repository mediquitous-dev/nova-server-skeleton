import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    kotlin("jvm") version "2.2.10"
    kotlin("plugin.spring") version "2.2.10"
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "2.2.10"
    kotlin("kapt") version "2.2.10"
    id("com.google.protobuf") version "0.8.13"
    id("org.jlleitschuh.gradle.ktlint") version "13.1.0"
}

group = "jp.nugu"
version = "0.0.1-SNAPSHOT"
description = "nova-skeleton"

val kotestVersion = "6.0"

// gRPC
val grpcVersion = "3.19.4"
val grpcKotlinVersion = "2.2.10"
val grpcProtoVersion = "1.44.1"

ktlint {
    reporters {
        reporter(ReporterType.JSON)
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    implementation("org.mapstruct:mapstruct:1.5.5.Final")

    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.springframework.boot:spring-boot-starter-data-redis")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")
    kaptTest("org.mapstruct:mapstruct-processor:1.5.5.Final")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    // JVM 접미사 제거 (멀티플랫폼이 아니므로)
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")

    // slf4j 비효율 개선
    implementation("io.github.oshai:kotlin-logging-jvm:5.1.1")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
