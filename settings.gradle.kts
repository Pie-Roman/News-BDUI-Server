rootProject.name = "News-BDUI-Server"

include(":common:view")

include("feature:news-card-feature")
include(":feature:news-list-feature")
include(":feature:tabs-feature")
include(":feature:search-feature")
include(":feature:search-result-feature")

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