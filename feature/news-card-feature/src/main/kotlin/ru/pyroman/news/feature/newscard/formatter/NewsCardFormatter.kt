package ru.pyroman.news.feature.newscard.formatter

import divkit.dsl.Url
import ru.pyroman.news.domain.article.model.Article
import ru.pyroman.news.feature.newscard.entity.NewsCardCategoryVo
import ru.pyroman.news.feature.newscard.entity.NewsCardVo

class NewsCardFormatter {

    fun format(article: Article): NewsCardVo? {
        val title = article.title
        val creator = article.creator.firstOrNull()?.let {
            "By $it"
        }
        val publishDate = article.pubDate
        val category = article.category.firstOrNull()?.let {
            NewsCardCategoryVo(it)
        }
        val imageUrl = article.imageUrl?.let { urlString ->
            try {
                Url.create(urlString)
            } catch (error: Throwable) {
                null
            }
        } ?: return null

        return NewsCardVo(
            title = title,
            creator = creator,
            imageUrl = imageUrl,
            publishDate = publishDate,
            category = category,
        )
    }
}