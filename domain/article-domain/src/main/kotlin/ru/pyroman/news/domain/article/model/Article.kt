package ru.pyroman.news.domain.article.model

data class Article(
    val id: String,
    val title: String,
    val creator: List<String>,
    val description: String,
    val pubDate: String?,
    val imageUrl: String?,
    val category: List<String>,
)