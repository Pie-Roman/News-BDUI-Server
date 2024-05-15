package ru.pyroman.news.feature.newscard

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.pyroman.news.feature.newscard.formatter.NewsCardFormatter

@Configuration
class NewsCardConfig {

    @Bean("newsCardFormatter")
    fun provideNewsCardFormatter(): NewsCardFormatter {
        return NewsCardFormatter()
    }
}