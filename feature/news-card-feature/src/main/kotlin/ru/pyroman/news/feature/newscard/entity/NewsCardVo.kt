package ru.pyroman.news.feature.newscard.entity

import divkit.dsl.Url

class NewsCardVo(
    val title: String,
    val creator: String?,
    val imageUrl: Url,
    val publishDate: String?,
    val category: NewsCardCategoryVo?,
)