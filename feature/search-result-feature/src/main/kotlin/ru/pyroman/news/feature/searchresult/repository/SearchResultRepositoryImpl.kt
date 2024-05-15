package ru.pyroman.news.feature.searchresult.repository

import ru.pyroman.news.common.view.View
import ru.pyroman.news.domain.article.model.ArticlesRequest
import ru.pyroman.news.domain.article.repository.ArticleRepository
import ru.pyroman.news.feature.searchresult.entity.SearchResultView
import ru.pyroman.news.feature.searchresult.formatter.SearchResultFormatter

internal class SearchResultRepositoryImpl(
    private val articleRepository: ArticleRepository,
    private val searchResultFormatter: SearchResultFormatter,
) : SearchResultRepository {

    override fun getView(searchInput: String): View {
        val articleList = articleRepository.getArticles(
            request = ArticlesRequest(
                query = searchInput,
            )
        )
        val vo = searchResultFormatter.format(
            articleList = articleList,
        )

        return SearchResultView(
            vo = vo,
        )
    }
}