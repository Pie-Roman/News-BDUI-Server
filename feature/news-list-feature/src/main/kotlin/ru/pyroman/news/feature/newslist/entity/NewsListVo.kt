package ru.pyroman.news.feature.newslist.entity

import ru.pyroman.news.feature.newscard.entity.NewsCardVo

internal class NewsListVo(
    val items: List<NewsCardVo>,
)