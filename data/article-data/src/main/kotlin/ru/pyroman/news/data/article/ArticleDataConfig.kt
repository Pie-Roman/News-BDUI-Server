package ru.pyroman.news.data.article

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.pyroman.news.data.article.datasource.ArticleDataSource
import ru.pyroman.news.data.article.mapper.ArticleMapper
import ru.pyroman.news.data.article.repository.ArticleRepositoryImpl
import ru.pyroman.news.domain.article.repository.ArticleRepository

@Configuration
class ArticleDataConfig {

    @Bean("articleDataSource")
    internal fun provideArticleDataSource(): ArticleDataSource {
        return ArticleDataSource()
    }

    @Bean("articleMapper")
    internal fun provideArticleMapper(): ArticleMapper {
        return ArticleMapper()
    }


    @Bean("articleRepository")
    fun provideArticleRepository(): ArticleRepository {
        return ArticleRepositoryImpl(
            articleDataSource = provideArticleDataSource(),
            articleMapper = provideArticleMapper(),
        )
    }
}