package ru.pyroman.news.data.article.mapper

import ru.pyroman.news.data.article.dto.ArticleDto
import ru.pyroman.news.data.article.dto.ArticleListDto
import ru.pyroman.news.domain.article.model.Article
import ru.pyroman.news.domain.article.model.ArticleList

internal class ArticleMapper {

    fun map(dto: ArticleListDto): ArticleList {
        val articles = dto.results.orEmpty().mapNotNull { articleDto ->
            articleDto?.let { map(it) }
        }

        return ArticleList(
            articles = articles,
        )
    }

    private fun map(dto: ArticleDto): Article? {
        return try {
            with(dto) {
                Article(
                    id = requireNotNull(article_id),
                    title = requireNotNull(title),
                    creator = creator.orEmpty().filterNotNull(),
                    description = requireNotNull(description),
                    pubDate = pubDate,
                    imageUrl = image_url,
                    category = category.orEmpty().filterNotNull(),
                )
            }
        } catch (error: Throwable) {
            null
        }
    }
}