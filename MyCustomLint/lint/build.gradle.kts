plugins {
    id("java-library")
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    compileOnly(libs.kotlin.stdlib)
    compileOnly(libs.lint.api)
    compileOnly(libs.lint.checks)
}

tasks.jar {
    manifest {
        attributes(
            "Lint-Registry-v2" to "com.alvaro.lint.MyIssueRegistry"
        )
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}