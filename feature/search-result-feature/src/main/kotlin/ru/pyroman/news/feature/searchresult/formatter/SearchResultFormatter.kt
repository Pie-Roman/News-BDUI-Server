package ru.pyroman.news.feature.searchresult.formatter

import ru.pyroman.news.domain.article.model.ArticleList
import ru.pyroman.news.feature.newscard.formatter.NewsCardFormatter
import ru.pyroman.news.feature.searchresult.entity.SearchResultVo

internal class SearchResultFormatter(
    private val newsCardFormatter: NewsCardFormatter,
) {

    fun format(articleList: ArticleList): SearchResultVo {
        val items = articleList.articles.mapNotNull { article ->
            newsCardFormatter.format(article)
        }

        return SearchResultVo(
            items = items,
        )
    }
}