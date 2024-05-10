package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.*
import divkit.dsl.scope.DivScope
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LIST_LAYOUT_ID

internal class NewsListView(
    private val vo: NewsListVo,
) : View {
    override fun getData(): ViewData {

        val divan = divan {
            data(
                logId = NEWS_LIST_LAYOUT_ID,
                states = singleRoot(
                    div = newsList(
                        vo = vo,
                    )
                )
            )
        }

        return ViewData.Factory.create(
            divan = divan,
        )
    }

    private fun DivScope.newsList(vo: NewsListVo): Div {
        return container(
            orientation = vertical,
            width = matchParentSize(),
            height = wrapContentSize(),
            items = vo.items.map { newsVo ->
                newsCard(vo = newsVo)
            },
            separator = containerSeparator(

            ),
        )
    }

    private fun DivScope.newsCard(vo: NewsCardVo): Div {
        return container(
            width = matchParentSize(),
            height = wrapContentSize(),
            orientation = horizontal,
            items = listOf(
                image(
                    width = wrapContentSize(),
                    height = wrapContentSize(),
                    imageUrl = vo.imageUrl,
                    alignmentHorizontal = left,
                ),
                newsCardInfo(vo = vo) + containerProps(
                    alignmentHorizontal = right,
                )
            ),
        )
    }

    private fun DivScope.newsCardInfo(vo: NewsCardVo): Container {
        return container(
            orientation = vertical,
            items = listOf(
                text(
                    text = vo.title,
                ),

            )
        )
    }
}