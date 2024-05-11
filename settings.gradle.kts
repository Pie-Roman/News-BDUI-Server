rootProject.name = "News-BDUI-Server"

include(":common:view")

include(":feature:news-list-feature")
include(":feature:tabs-feature")

include(":domain:article-domain")

include(":data:article-data")

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