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
    useModule(ProjectModules.Feature.searchFeature)
    useModule(ProjectModules.Feature.searchResultFeature)
    useModule(ProjectModules.Feature.tabsFeature)
}

allprojects {
    tasks.withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
            freeCompilerArgs += "-Xcontext-receivers"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
