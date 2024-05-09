package ru.pyroman.news.data.article.mapper

import ru.pyroman.news.data.article.dto.ArticleDto
import ru.pyroman.news.data.article.dto.ArticleListDto
import ru.pyroman.news.data.article.dto.ArticleSourceDto
import ru.pyroman.news.domain.article.model.Article
import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.domain.article.model.ArticleSource

internal class ArticleMapper {

    fun map(dto: ArticleListDto): ArticleList {
        val articles = dto.articles.orEmpty().mapNotNull { articleDto ->
            articleDto?.let { map(it) }
        }

        return ArticleList(
            articles = articles,
        )
    }

    private fun map(dto: ArticleDto): Article {
        return with(dto) {
            Article(
                source = source?.let { map(it) },
                author = author,
                title = title.orEmpty(),
                description = description.orEmpty(),
                url = url,
                urlToImage = urlToImage,
                publishedAt = publishedAt,
                content = content.orEmpty()
            )
        }
    }

    private fun map(dto: ArticleSourceDto): ArticleSource {
        return with(dto) {
            ArticleSource(
                id = id,
                name = name.orEmpty(),
            )
        }
    }
}