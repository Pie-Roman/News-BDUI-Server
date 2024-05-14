package ru.pyroman.news.feature.searchResultresult

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.pyroman.news.data.article.ArticleDataConfig
import ru.pyroman.news.feature.newscard.NewsCardConfig
import ru.pyroman.news.feature.searchResultresult.controller.SearchResultController
import ru.pyroman.news.feature.searchresult.formatter.SearchResultFormatter
import ru.pyroman.news.feature.searchresult.repository.SearchResultRepository
import ru.pyroman.news.feature.searchresult.repository.SearchResultRepositoryImpl
import ru.pyroman.news.feature.searchresult.service.SearchResultService
import ru.pyroman.news.feature.searchresult.service.SearchResultServiceImpl

@Configuration
@Import(
    value = [
        ArticleDataConfig::class,
        NewsCardConfig::class,
    ]
)
class SearchResultConfig(
    @Autowired private val articleDataConfig: ArticleDataConfig,
    @Autowired private val newsCardConfig: NewsCardConfig,
) {

    @Bean("searchResultFormatter")
    internal fun searchResultFormatter(): SearchResultFormatter {
        return SearchResultFormatter(
            newsCardFormatter = newsCardConfig.provideNewsCardFormatter(),
        )
    }

    @Bean("searchResultRepository")
    internal fun provideSearchResultRepository(): SearchResultRepository {
        return SearchResultRepositoryImpl(
            articleRepository = articleDataConfig.provideArticleRepository(),
            searchResultFormatter = searchResultFormatter(),
        )
    }

    @Bean("searchResultService")
    internal fun provideSearchResultService(): SearchResultService {
        return SearchResultServiceImpl(
            searchResultRepository = provideSearchResultRepository(),
        )
    }

    @Bean("searchResultController")
    fun provideSearchResultController(): SearchResultController {
        return SearchResultController(
            searchResultService = provideSearchResultService(),
        )
    }
}