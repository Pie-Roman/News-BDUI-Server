package ru.pyroman.news.feature.newslist.formatter

import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.feature.newscard.formatter.NewsCardFormatter
import ru.pyroman.news.feature.newslist.entity.NewsListVo

internal class NewsListFormatter(
    private val newsCardFormatter: NewsCardFormatter,
) {

    fun format(articleList: ArticleList): NewsListVo {
        val items = articleList.articles.mapNotNull { article ->
            newsCardFormatter.format(article)
        }

        return NewsListVo(
            items = items,
        )
    }
}