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
    implementation("com.typesafe:config:1.3.0")
    implementation("com.google.code.gson:gson:2.11.0")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlin {
        jvmToolchain(11)
    }
}
tasks.withType<Test> {
    useTestNG()
}

tasks.register<Test>("testFactory") {
    systemProperties["browser"] = project.findProperty("browser")?: "firefox"
    systemProperties["stand"] = project.findProperty("stand")?: "244"

    useTestNG {
        suites("data/suites/RunTestFactory.xml") // Используем правильные кавычки
    }

}
tasks.register<Test>("CheckAdminProfile") {
    systemProperties["browser"] = project.findProperty("browser")?: "firefox"
    systemProperties["stand"] = project.findProperty("stand")?: "244"
    useTestNG {
        suites("data/suites/CheckAdminProfile.xml") // Используем правильные кавычки
    }
}


sourceSets {
    test {
        resources {
            // Добавляем вашу папку data/suites
            srcDir("data/suites")
        }
    }
}