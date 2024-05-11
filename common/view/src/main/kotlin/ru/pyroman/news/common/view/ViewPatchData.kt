package ru.pyroman.news.common.view

import divkit.dsl.DivanPatch

class ViewPatchData private constructor(
    val divanPatch: DivanPatch,
) {

    object Factory {

        fun create(
            divanPatch: DivanPatch,
        ): ViewPatchData {

            return ViewPatchData(
                divanPatch = divanPatch,
            )
        }
    }
}