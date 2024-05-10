import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlinJvm
    springFrameworkBoot
    springDependencyManagement
    kotlinSpring
}

group = "ru.pyroman.news"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

dependencies {
    useCommonLibraries()

    useModule(ProjectModules.Feature.newsListFeature)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
