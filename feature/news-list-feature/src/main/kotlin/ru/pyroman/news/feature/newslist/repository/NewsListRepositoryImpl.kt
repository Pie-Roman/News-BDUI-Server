package ru.pyroman.news.feature.newslist.repository

import ru.pyroman.news.common.view.View
import ru.pyroman.news.domain.article.model.ArticlesRequest
import ru.pyroman.news.domain.article.repository.ArticleRepository
import ru.pyroman.news.feature.newslist.entity.NewsListView
import ru.pyroman.news.feature.newslist.formatter.NewsListFormatter

internal class NewsListRepositoryImpl(
    private val articleRepository: ArticleRepository,
    private val newsListFormatter: NewsListFormatter,
) : NewsListRepository {

    override fun getView(): View {
        val articleList = articleRepository.getArticles(ArticlesRequest())
        val vo = newsListFormatter.format(
            articleList = articleList,
        )

        return NewsListView(
            vo = vo,
        )
    }
}