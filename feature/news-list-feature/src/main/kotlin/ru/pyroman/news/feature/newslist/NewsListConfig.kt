package ru.pyroman.news.feature.newslist

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.pyroman.news.feature.newslist.controller.NewsListController
import ru.pyroman.news.feature.newslist.repository.NewsListRepository
import ru.pyroman.news.feature.newslist.repository.NewsListRepositoryImpl
import ru.pyroman.news.feature.newslist.service.NewsListService
import ru.pyroman.news.feature.newslist.service.NewsListServiceImpl

@Configuration
class NewsListConfig {

    @Bean("newsListRepository")
    fun provideNewsListRepository(): NewsListRepository {
        return NewsListRepositoryImpl()
    }

    @Bean("newsListService")
    fun provideNewsListService(): NewsListService {
        return NewsListServiceImpl(
            newsListRepository = provideNewsListRepository(),
        )
    }

    @Bean("newsListController")
    fun provideNewsListController(): NewsListController {
        return NewsListController(
            service = provideNewsListService(),
        )
    }
}