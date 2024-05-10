package ru.pyroman.news.feature.newslist.formatter

import divkit.dsl.Url
import ru.pyroman.news.domain.article.model.Article
import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.feature.newslist.entity.NewsCardVo
import ru.pyroman.news.feature.newslist.entity.NewsListVo

internal class NewsListFormatter {

    fun format(articleList: ArticleList): NewsListVo {
        val items = articleList.articles.map { article ->
            format(article)
        }

        return NewsListVo(
            items = items,
        )
    }

    private fun format(article: Article): NewsCardVo {
        val title = article.title
        val creator = article.creator.firstOrNull()
        val publishDate = ""
        val imageUrl = article.imageUrl?.let { urlString ->
            try {
                Url.create(urlString)
            } catch (error: Throwable) {
                null
            }
        }

        return NewsCardVo(
            title = title,
            creator = creator,
            imageUrl = imageUrl,
            publishDate = publishDate,
        )
    }
}