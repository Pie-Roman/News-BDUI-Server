package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.Container
import divkit.dsl.Div
import divkit.dsl.Url
import divkit.dsl.bold
import divkit.dsl.center
import divkit.dsl.color
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.edgeInsets
import divkit.dsl.fixedSize
import divkit.dsl.gallery
import divkit.dsl.image
import divkit.dsl.matchParentSize
import divkit.dsl.row
import divkit.dsl.scope.DivScope
import divkit.dsl.solidBackground
import divkit.dsl.text
import divkit.dsl.vertical
import divkit.dsl.wrapContentSize
import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.newscard.entity.newsCard
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LIST_LAYOUT_ID
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LOGO_IMAGE_URL
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LOGO_TEXT

internal class NewsListView(
    private val vo: NewsListVo,
) : View() {

    override val layoutId = NEWS_LIST_LAYOUT_ID
    override fun DivScope.layout(): Div {
        return newsList(
            vo = vo,
        )
    }

    private fun DivScope.newsList(vo: NewsListVo): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            orientation = vertical,
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            background = listOf(solidBackground(color = color("#FFFFFF"))),
            items = listOf(
                newsLogo() + containerProps(
                    margins = edgeInsets(
                        top = 30,
                        bottom = 30,
                    )
                ),
                newsGallery(vo),
            ),
        )
    }

    private fun DivScope.newsLogo(): Container {
        return row(
            width = wrapContentSize(),
            height = wrapContentSize(),
            alignmentHorizontal = center,
            contentAlignmentVertical = center,
            items = listOf(
                image(
                    width = fixedSize(24),
                    height = fixedSize(24),
                    imageUrl = Url.create(NEWS_LOGO_IMAGE_URL),
                    margins = edgeInsets(
                        right = 10,
                    )
                ),
                text(
                    height = matchParentSize(),
                    text = NEWS_LOGO_TEXT,
                    textAlignmentVertical = center,
                    fontSize = 15,
                    lineHeight = 20,
                    fontWeight = bold,
                    letterSpacing = 0.0,
                    textColor = color("#180E19"),
                )
            )
        )
    }

    private fun DivScope.newsGallery(vo: NewsListVo): Div {
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