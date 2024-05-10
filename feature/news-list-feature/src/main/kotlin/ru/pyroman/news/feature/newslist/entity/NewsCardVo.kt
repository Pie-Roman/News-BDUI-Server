package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.Url

class NewsCardVo(
    val title: String,
    val creator: String?,
    val imageUrl: Url?,
    val publishDate: String,
)