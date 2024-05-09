package ru.pyroman.news.domain.article.model

import java.time.LocalDateTime

data class Article(
    val source: ArticleSource?,
    val author: String?,
    val title: String,
    val description: String,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: LocalDateTime?,
    val content: String,
)