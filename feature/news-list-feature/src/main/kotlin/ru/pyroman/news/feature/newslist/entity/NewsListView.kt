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
            width = matchParentSize(),
            height = matchParentSize(),
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            background = listOf(solidBackground(color = color("#FFFFFF"))),
            items = listOf(
                newsGallery(vo)
            ),
        )
    }

    private fun DivScope.newsGallery(vo: NewsListVo): Div {
        return gallery(
            orientation = vertical,
            width = matchParentSize(),
            height = wrapContentSize(),
            items = vo.items.map { newsVo ->
                newsCard(vo = newsVo)
            },
        )
    }

    private fun DivScope.newsCard(vo: NewsCardVo): Div {
        return container(
            width = matchParentSize(),
            height = wrapContentSize(),
            orientation = vertical,
            items = listOf(
                container(
                    width = matchParentSize(),
                    height = wrapContentSize(),
                    orientation = horizontal,
                    items = listOf(
                        image(
                            width = fixedSize(128),
                            height = fixedSize(128),
                            imageUrl = vo.imageUrl,
                            alignmentHorizontal = left,
                        ),
                        newsCardInfo(vo = vo) + containerProps(
                            alignmentHorizontal = right,
                        )
                    ),
                ),
                separator(
                    width = matchParentSize(),
                    height = fixedSize(1),
                    background = listOf(solidBackground(color = color("#EEEEEE"))),
                    margins = edgeInsets(
                        top = 32,
                        bottom = 20,
                    ),
                ),
            ),
        )
    }

    private fun DivScope.newsCardInfo(vo: NewsCardVo): Container {
        return container(
            orientation = overlap,
            margins = edgeInsets(
                left = 10,
                right = 10,
            ),
            items = listOf(
                text(
                    text = vo.title,
                    fontSize = 14,
                    fontWeight = bold,
                    lineHeight = 20,
                    letterSpacing = 0.0,
                    textColor = color("#180E19"),
                    alignmentVertical = top,
                    alignmentHorizontal = left,
                ),
            )
        )
    }
}