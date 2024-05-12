package ru.pyroman.news.common.view

import divkit.dsl.Div
import divkit.dsl.Trigger
import divkit.dsl.Variable
import divkit.dsl.data
import divkit.dsl.divan
import divkit.dsl.divanPatch
import divkit.dsl.patch
import divkit.dsl.patchChange
import divkit.dsl.scope.DivScope
import divkit.dsl.singleRoot

abstract class View {

    abstract val layoutId: String

    abstract fun DivScope.layout(): Div

    open val DivScope.variableTriggers: List<Trigger>
        get() = emptyList()

    open val DivScope.variables: List<Variable>
        get() = emptyList()

    fun getPatchData(id: String): ViewPatchData {
        val divanPatch = divanPatch {
            patch(
                changes = listOf(
                    patchChange(
                        id = id,
                        items = listOf(
                            layout(),
                        )
                    )
                )
            )
        }

        return ViewPatchData.Factory.create(
            divanPatch = divanPatch,
        )
    }

    fun getData(): ViewData {
        val divan = divan {
            data(
                logId = layoutId,
                states = singleRoot(
                    div = layout(),
                ),
                variableTriggers = variableTriggers,
                variables = variables,
            )
        }

        return ViewData.Factory.create(
            divan = divan,
        )
    }
}