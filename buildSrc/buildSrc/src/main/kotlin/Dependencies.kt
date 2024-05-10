object Dependencies {
    object Kotlin {
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect"
    }
    object SpringFramework {
        object Boot {
            private const val version = "3.1.2"
            const val group = "org.springframework.boot"
            const val starterWeb = "$group:spring-boot-starter-web:$version"
            const val starterWebFlux = "$group:spring-boot-starter-webflux:$version"

            // test
            const val starterTest = "$group:spring-boot-starter-test:$version"
        }
    }
    object Jackson {
        object Module {
            const val kotlin = "com.fasterxml.jackson.module:jackson-module-kotlin"
        }
    }
    object PostgreSQL {
        const val postgreSQL = "org.postgresql:postgresql"
    }
    object Divkit {
        object JsonBuilder {
            const val jsonBuilder = "com.yandex:kotlin-json-builder"
        }
    }
}