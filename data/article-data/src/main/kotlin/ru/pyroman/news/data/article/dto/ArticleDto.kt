package ru.pyroman.news.data.article.dto

internal class ArticleDto(
    val article_id: String?,
    val title: String?,
    val creator: List<String?>?,
    val description: String?,
    val pubDate: String?,
    val image_url: String?,
    val category: List<String?>?,
)