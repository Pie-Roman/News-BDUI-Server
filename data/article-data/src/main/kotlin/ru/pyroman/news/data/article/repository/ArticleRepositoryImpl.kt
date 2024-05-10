package ru.pyroman.news.data.article.repository

import ru.pyroman.news.data.article.datasource.ArticleDataSource
import ru.pyroman.news.data.article.mapper.ArticleMapper
import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.domain.article.model.ArticlesRequest
import ru.pyroman.news.domain.article.repository.ArticleRepository

internal class ArticleRepositoryImpl(
    private val articleDataSource: ArticleDataSource,
    private val articleMapper: ArticleMapper,
) : ArticleRepository {

    override fun getArticles(request: ArticlesRequest): ArticleList {
        val articlesListDto = articleDataSource.getArticles(request)
        return articleMapper.map(articlesListDto)
    }
}