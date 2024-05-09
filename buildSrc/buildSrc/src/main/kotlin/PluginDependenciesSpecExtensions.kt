import org.gradle.kotlin.dsl.kotlin
import org.gradle.kotlin.dsl.version
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.kotlinJvm: PluginDependencySpec
    get() = kotlin(Plugins.Kotlin.jvm) version Plugins.Kotlin.version

val PluginDependenciesSpec.kotlinSpring: PluginDependencySpec
    get() = kotlin(Plugins.Kotlin.spring) version Plugins.Kotlin.version

val PluginDependenciesSpec.springDependencyManagement: PluginDependencySpec
    get() = id(Plugins.Spring.dependencyManagement) version Plugins.Spring.version

val PluginDependenciesSpec.springFrameworkBoot: PluginDependencySpec
    get() = id(Plugins.SpringFramework.Boot.boot) version Plugins.SpringFramework.Boot.version