val allureVersion = "2.24.0"
val aspectJVersion = "1.9.20.1"

val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}

plugins {
    kotlin("jvm") version "1.6.10"
    application
}
repositories {
    mavenCentral()
    maven {
        url = uri("https://artifactory.blogic.ru/artifactory/libs-release")
        mavenContent {
        }
        name = "libs-release"
    }
}
dependencies {
    implementation("com.microsoft.playwright:playwright:1.43.0")
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.testng:testng:7.5")
//    implementation("org.seleniumhq.selenium:selenium-java:4.23.0")
    implementation("com.typesafe:config:1.3.0")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("io.celebrium:celebrium-web:0.0.8"){
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jre8")
    }
    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    // Add necessary Allure dependencies to dependencies section
    testImplementation("io.qameta.allure:allure-testng")
    agent("org.aspectj:aspectjweaver:${aspectJVersion}")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
tasks.withType<Test> {
    systemProperties["browser"] = project.findProperty("browser")?: "firefox"
    systemProperties["stand"] = project.findProperty("stand")?: "244"
    systemProperties["grid.url"] = project.findProperty("grid.url")?: "http://192.168.80.1:4444/wd/hub"

    jvmArgs = listOf(
        "-javaagent:${agent.singleFile}"
    )

}

tasks.register<Test>("testFactory") {

    useTestNG {
        suites("data/suites/RunTestFactory.xml") // Используем правильные кавычки
    }

}
tasks.register<Test>("CheckAdminProfile") {
    useTestNG {
        suites("data/suites/CheckAdminProfile.xml") // Используем правильные кавычки
    }
}
tasks.register<Test>("NotificationCheck") {
    useTestNG {
        suites("data/suites/NotificationCheck.xml") // Используем правильные кавычки
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