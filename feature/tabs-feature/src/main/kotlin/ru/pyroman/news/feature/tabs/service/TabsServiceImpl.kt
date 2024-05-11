package ru.pyroman.news.feature.tabs.service

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.tabs.repository.TabsRepository

internal class TabsServiceImpl(
    private val tabsRepository: TabsRepository,
) : TabsService {

    override fun getView(): View {
        return tabsRepository.getView()
    }
}