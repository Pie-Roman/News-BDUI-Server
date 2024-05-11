package ru.pyroman.news.common.view

import divkit.dsl.Div
import divkit.dsl.DivanPatch
import divkit.dsl.Patch
import divkit.dsl.data
import divkit.dsl.divan
import divkit.dsl.divanPatch
import divkit.dsl.patch
import divkit.dsl.scope.DivScope
import divkit.dsl.singleRoot

abstract class View {

    abstract val layoutId: String

    abstract fun DivScope.layout(): Div

    open fun DivScope.patchChanges(): List<Patch.Change> = emptyList()

    fun getPatch(): DivanPatch {
        val divanPatch = divanPatch {
            patch(
                changes = patchChanges()
            )
        }

        return divanPatch
    }

    fun getData(): ViewData {
        val divan = divan {
            data(
                logId = layoutId,
                states = singleRoot(
                    div = layout(),
                )
            )
        }

        return ViewData.Factory.create(
            divan = divan,
        )
    }
}