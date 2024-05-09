package ru.pyroman.news.domain.article.repository

import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.domain.article.model.ArticlesRequest

interface ArticleRepository {

    fun getArticles(request: ArticlesRequest): ArticleList
}