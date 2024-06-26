plugins {
    `kotlin-dsl`
    kotlinJvm
    springFrameworkBoot
    springDependencyManagement
    kotlinSpring
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    useCommonLibraries()
    useModule(ProjectModules.Domain.articleDomain)
}