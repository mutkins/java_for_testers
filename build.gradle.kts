plugins {
    kotlin("jvm") version "1.9.21"
    application
}
repositories {
    mavenCentral()
}
dependencies {
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    implementation("org.netbeans.external:testng-6.8.1-dist:RELEASE121")
    implementation("org.seleniumhq.selenium:selenium-java:4.23.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
    }
}
tasks.withType<Test> {
    useTestNG()
}