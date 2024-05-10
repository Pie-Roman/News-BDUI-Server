package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.*
import divkit.dsl.scope.DivScope
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LIST_LAYOUT_ID
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LOGO_IMAGE_URL
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LOGO_TEXT

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
                    height = fixedSize(128),
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
            height = matchParentSize(),
            orientation = vertical,
            contentAlignmentVertical = space_between,
            margins = edgeInsets(
                left = 10,
                right = 10,
            ),
            items = listOf(
                column(
                    items = listOfNotNull(
                        text(
                            text = vo.title,
                            fontSize = 14,
                            lineHeight = 20,
                            fontWeight = bold,
                            letterSpacing = 0.0,
                            textColor = color("#180E19"),
                            alignmentHorizontal = left,
                            maxLines = 3,
                            autoEllipsize = true,
                        ),
                        vo.creator?.let { creator ->
                            text(
                                text = creator,
                                fontSize = 13,
                                lineHeight = 22,
                                fontWeight = bold,
                                letterSpacing = 0.0,
                                textColor = color("#909090"),
                                margins = edgeInsets(
                                    top = 8,
                                )
                            )
                        },
                    )
                ),
                newsCardInfoBottomBlock (vo) + containerProps(
                    alignmentHorizontal = left,
                ),
            )
        )
    }

    private fun DivScope.newsCardInfoBottomBlock(vo: NewsCardVo): Container {
        return container(
            width = wrapContentSize(),
            height = wrapContentSize(),
            orientation = horizontal,
            contentAlignmentVertical = center,
            items = buildList {
                vo.category?.let { category ->
                    add(
                        text(
                            text = category.text,
                            textAlignmentVertical = center,
                            fontSize = 13,
                            fontWeight = bold,
                            lineHeight = 22,
                            letterSpacing = 0.0,
                            textColor = color("#69BDFD"),
                            margins = edgeInsets(
                                right = 10,
                            )
                        )
                    )
                }
                vo.publishDate?.let { publishDate ->
                    add(
                        text(
                            text = publishDate,
                            textAlignmentVertical = center,
                            fontSize = 13,
                            lineHeight = 22,
                            fontWeight = bold,
                            letterSpacing = 0.0,
                            textColor = color("#909090"),
                        )
                    )
                }
            },
        )
    }
}