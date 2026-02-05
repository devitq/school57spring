import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    id("org.openapi.generator") version "7.3.0"
    kotlin("jvm")
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.5.9"
    id("io.spring.dependency-management") version "1.1.7"
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

openApiGenerate {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/openapi.yaml")
    outputDir.set("$buildDir/generated/server")

    apiPackage.set("com.example.api")
    modelPackage.set("com.example.model")

    configOptions.set(
        mapOf(
            "interfaceOnly" to "true",
            "useSpringBoot3" to "true",
            "serializationLibrary" to "jackson"
        )
    )
}

tasks.register<GenerateTask>("generateClient") {
    generatorName.set("kotlin-spring")
    inputSpec.set("$rootDir/openapi.yaml")
    outputDir.set("$buildDir/generated/client")

    apiPackage.set("com.example.client.api")
    modelPackage.set("com.example.client.model")

    configOptions.set(
        mapOf(
            "library" to "spring-cloud",
            "useSpringBoot3" to "true",
            "serializationLibrary" to "jackson"
        )
    )
}

