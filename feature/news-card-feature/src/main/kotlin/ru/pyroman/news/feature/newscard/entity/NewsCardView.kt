package ru.pyroman.news.feature.newscard.entity

import divkit.dsl.Container
import divkit.dsl.Div
import divkit.dsl.bold
import divkit.dsl.center
import divkit.dsl.color
import divkit.dsl.column
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.edgeInsets
import divkit.dsl.fixedSize
import divkit.dsl.horizontal
import divkit.dsl.image
import divkit.dsl.left
import divkit.dsl.matchParentSize
import divkit.dsl.right
import divkit.dsl.scope.DivScope
import divkit.dsl.separator
import divkit.dsl.solidBackground
import divkit.dsl.space_between
import divkit.dsl.text
import divkit.dsl.vertical
import divkit.dsl.wrapContentSize

fun DivScope.newsCard(vo: NewsCardVo): Div {
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