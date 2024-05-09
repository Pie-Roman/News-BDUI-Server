import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add

fun DependencyHandler.useModule(moduleNotation: String) {
    add(IMPLEMENTATION, project(mapOf("path" to moduleNotation)))
}

fun DependencyHandler.useCommonLibraries() {
    add(IMPLEMENTATION, Dependencies.SpringFramework.Boot.starterWeb) {
        excludeSpringLogging()
    }
    add(IMPLEMENTATION, Dependencies.SpringFramework.Boot.starterWebFlux)  {
        excludeSpringLogging()
    }

    add(IMPLEMENTATION, Dependencies.Jackson.Module.kotlin)

    add(IMPLEMENTATION, Dependencies.Kotlin.reflect)

    add(RUNTIME_ONLY, Dependencies.PostgreSQL.postgreSQL)

    add(TEST_IMPLEMENTATION, Dependencies.SpringFramework.Boot.starterTest)
}

fun DependencyHandler.useDivkit() {
    add(IMPLEMENTATION, Dependencies.Divkit.JsonBuilder.jsonBuilder)
}

fun DependencyHandler.useCommonFeatureLibraries() {
    useCommonLibraries()
    useDivkit()
}

fun DependencyHandler.useCommonFeatureModules() {
    useModule(ProjectModules.Common.view)
}

private fun <T : ModuleDependency> T.excludeSpringLogging() {
    exclude(group = Dependencies.SpringFramework.Boot.group, module = "spring-boot-starter-logging")
    exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
}

@Suppress("UNCHECKED_CAST")
private fun <T : ModuleDependency> T.exclude(group: String? = null, module: String? = null): T =
    exclude(excludeMapFor(group, module)) as T

private fun excludeMapFor(group: String?, module: String?): Map<String, String> =
    mapOfNonNullValuesof(
        "group" to group,
        "module" to module,
    )

private fun mapOfNonNullValuesof(vararg entries: Pair<String, String?>): Map<String, String> =
    entries.mapNotNull { entry ->
        entry.second?.let { value ->
            entry.first to value
        }
    }.toMap()

private const val COMPILE_ONLY = "compileOnly"
private const val IMPLEMENTATION = "implementation"
private const val TEST_IMPLEMENTATION = "testImplementation"
private const val RUNTIME_ONLY = "runtimeOnly"
private const val API = "api"