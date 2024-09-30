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
    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.6.10")
    implementation("org.testng:testng:-7.5.0")
//    implementation("org.seleniumhq.selenium:selenium-java:4.23.0")
    implementation("com.typesafe:config:1.3.0")
    implementation("com.google.code.gson:gson:2.11.0")
    implementation("io.celebrium:celebrium-web:0.0.8"){
        exclude(group = "org.jetbrains.kotlin", module = "kotlin-stdlib-jre8")
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
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