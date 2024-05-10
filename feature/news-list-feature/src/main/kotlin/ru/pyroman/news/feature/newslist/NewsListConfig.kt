package ru.pyroman.news.feature.newslist

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import ru.pyroman.news.data.article.ArticleDataConfig
import ru.pyroman.news.feature.newslist.controller.NewsListController
import ru.pyroman.news.feature.newslist.formatter.NewsListFormatter
import ru.pyroman.news.feature.newslist.repository.NewsListRepository
import ru.pyroman.news.feature.newslist.repository.NewsListRepositoryImpl
import ru.pyroman.news.feature.newslist.service.NewsListService
import ru.pyroman.news.feature.newslist.service.NewsListServiceImpl

@Configuration
@Import(
    value = [
        ArticleDataConfig::class
    ]
)
class NewsListConfig(
    @Autowired private val articleDataConfig: ArticleDataConfig
) {

    @Bean("newsListFormatter")
    internal fun provideNewsListFormatter(): NewsListFormatter {
        return NewsListFormatter()
    }

    @Bean("newsListRepository")
    internal fun provideNewsListRepository(): NewsListRepository {
        return NewsListRepositoryImpl(
            articleRepository = articleDataConfig.provideArticleRepository(),
            newsListFormatter = provideNewsListFormatter(),
        )
    }

    @Bean("newsListService")
    internal fun provideNewsListService(): NewsListService {
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