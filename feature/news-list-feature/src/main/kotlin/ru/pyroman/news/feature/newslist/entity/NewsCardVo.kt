package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.Url

class NewsCardVo(
    val title: String,
    val author: String?,
    val publishDate: String,
    val imageUrl: Url?,
)