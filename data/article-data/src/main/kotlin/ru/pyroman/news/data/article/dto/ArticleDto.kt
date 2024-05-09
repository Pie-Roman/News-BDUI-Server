package ru.pyroman.news.data.article.dto

import java.time.LocalDateTime

internal class ArticleDto(
    val source: ArticleSourceDto?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: LocalDateTime?,
    val content: String?,
)