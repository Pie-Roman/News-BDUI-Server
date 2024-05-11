package ru.pyroman.news.feature.tabs

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.pyroman.news.feature.tabs.controller.TabsController
import ru.pyroman.news.feature.tabs.formatter.TabsFormatter
import ru.pyroman.news.feature.tabs.repository.TabsRepository
import ru.pyroman.news.feature.tabs.repository.TabsRepositoryImpl
import ru.pyroman.news.feature.tabs.service.TabsService
import ru.pyroman.news.feature.tabs.service.TabsServiceImpl

@Configuration
class TabsConfig {

    @Bean("tabsFormatter")
    internal fun provideTabsFormatter(): TabsFormatter {
        return TabsFormatter()
    }

    @Bean("tabsRepository")
    internal fun provideTabsRepository(): TabsRepository {
        return TabsRepositoryImpl(
            tabsFormatter = provideTabsFormatter(),
        )
    }

    @Bean("tabsService")
    internal fun provideTabsService(): TabsService {
        return TabsServiceImpl(
            tabsRepository = provideTabsRepository(),
        )
    }

    @Bean("tabsController")
    fun provideTabsController(): TabsController {
        return TabsController(
            service = provideTabsService(),
        )
    }
}