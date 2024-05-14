package ru.pyroman.news.feature.searchresult.entity

import divkit.dsl.Div
import divkit.dsl.gallery
import divkit.dsl.matchParentSize
import divkit.dsl.scope.DivScope
import divkit.dsl.vertical
import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.newscard.entity.newsCard
import ru.pyroman.news.feature.searchresult.SearchResultConstants

internal class SearchResultView(
    private val vo: SearchResultVo,
) : View() {

    override val layoutId = SearchResultConstants.SEARCH_RESULT_LAYOUT_ID

    override fun DivScope.layout(): Div {
        return searchResultView(vo = vo)
    }

    private fun DivScope.searchResultView(vo: SearchResultVo): Div {
        return gallery(
            orientation = vertical,
            width = matchParentSize(),
            height = matchParentSize(),
            items = vo.items.map { newsVo ->
                newsCard(vo = newsVo)
            },
        )
    }
}