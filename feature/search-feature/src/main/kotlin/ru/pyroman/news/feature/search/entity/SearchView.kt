package ru.pyroman.news.feature.search.entity

import divkit.dsl.Div
import divkit.dsl.container
import divkit.dsl.matchParentSize
import divkit.dsl.scope.DivScope
import divkit.dsl.vertical
import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_LAYOUT_ID

class SearchView : View() {

    override val layoutId = SEARCH_LAYOUT_ID
    override fun DivScope.layout(): Div {
        return searchView()
    }

    private fun DivScope.searchView(): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            orientation = vertical,
        )
    }
}