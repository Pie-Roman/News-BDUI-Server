package ru.pyroman.news.feature.search.entity

import divkit.dsl.Custom
import divkit.dsl.Div
import divkit.dsl.container
import divkit.dsl.custom
import divkit.dsl.customProps
import divkit.dsl.edgeInsets
import divkit.dsl.matchParentSize
import divkit.dsl.scope.DivScope
import divkit.dsl.vertical
import divkit.dsl.wrapContentSize
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
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            items = listOf(
                search() + customProps(
                    margins = edgeInsets(
                        top = 30,
                        bottom = 30,
                    )
                ),
            )
        )
    }

    private fun DivScope.search(): Custom {
        return custom(
            customType = "search",
            width = matchParentSize(),
            height = wrapContentSize(),
        )
    }
}