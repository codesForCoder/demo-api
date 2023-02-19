plugins {
	java
	id("org.springframework.boot") version "3.0.2"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.aniket"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

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
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("com.github.javafaker:javafaker:1.0.2")
	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springframework.boot:spring-boot-starter-data-rest")
	implementation("com.h2database:h2")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")
	implementation ("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.cloud:spring-cloud-starter:4.0.1")
	implementation("org.apache.velocity:velocity:1.7")
	implementation(files("libs/demoapi-final-plain.jar"))




}

tasks.withType<Test> {
	useJUnitPlatform()
}
tasks.getByName<Jar>("jar") {
	enabled = false
}
tasks.named<org.springframework.boot.gradle.tasks.bundling.BootJar>("bootJar") {
	manifest {
		attributes("Main-Class" to "org.springframework.boot.loader.PropertiesLauncher")
	}
}