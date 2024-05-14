package ru.pyroman.news.feature.search

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.pyroman.news.feature.search.controller.SearchController
import ru.pyroman.news.feature.search.repository.SearchRepository
import ru.pyroman.news.feature.search.repository.SearchRepositoryImpl
import ru.pyroman.news.feature.search.service.SearchService
import ru.pyroman.news.feature.search.service.SearchServiceImpl

@Configuration
class SearchConfig {

    @Bean("searchRepository")
    internal fun provideSearchRepository(): SearchRepository {
        return SearchRepositoryImpl()
    }

    @Bean("searchService")
    internal fun provideSearchService(): SearchService {
        return SearchServiceImpl(
            searchRepository = provideSearchRepository(),
        )
    }

    @Bean("searchController")
    fun provideSearchController(): SearchController {
        return SearchController(
            searchService = provideSearchService(),
        )
    }
}