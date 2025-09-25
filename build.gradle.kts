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

	// MapStruct는 Lombok의 getter, setter, builder를 이용하여 생성되므로 Lombok보다 먼저 dependency가 선언 되는 경우 정상적으로 실행할 수 없습니다.
	implementation("org.mapstruct:mapstruct:1.5.5.Final")

	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	testImplementation("org.springframework.kafka:spring-kafka-test")
	kapt("org.mapstruct:mapstruct-processor:1.5.5.Final")
	kaptTest("org.mapstruct:mapstruct-processor:1.5.5.Final")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
	testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")

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
