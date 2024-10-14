plugins {
    kotlin("jvm") version "1.9.10" // или ваша версия
    id("io.qameta.allure") version "2.11.2"
    id("java") // добавляем плагин для работы с JUnit и Cucumber
}

repositories {
    mavenCentral()
}

dependencies {
    // Kotlin
    implementation(kotlin("stdlib"))

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    // Cucumber
    implementation("io.cucumber:cucumber-java:7.15.0")  // Cucumber для Java
    implementation("io.cucumber:cucumber-junit:7.15.0") // Cucumber для JUnit

    // JUnit
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")

    // Playwright
    implementation("com.microsoft.playwright:playwright:1.39.0") // Убедитесь, что версия Playwright соответствует вашей

    // Allure
    implementation("io.qameta.allure:allure-cucumber7-jvm:2.20.1") // Allure с поддержкой Cucumber 7
    implementation("com.typesafe:config:1.3.0")
}

tasks.withType<Test> {
    useJUnitPlatform() // Запускаем тесты через JUnit 5
    testLogging {
        events("passed", "skipped", "failed")
    }
}