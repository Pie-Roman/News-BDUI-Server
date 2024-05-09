rootProject.name = "News-BDUI-Server"

include(":common:view")

include(":feature:news-list-feature")

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        flatDir {
            dirs("libs")
        }
    }
}