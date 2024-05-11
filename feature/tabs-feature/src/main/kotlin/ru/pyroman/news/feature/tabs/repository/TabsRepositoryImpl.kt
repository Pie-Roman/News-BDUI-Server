package ru.pyroman.news.feature.tabs.repository

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.tabs.entity.TabsView
import ru.pyroman.news.feature.tabs.formatter.TabsFormatter

internal class TabsRepositoryImpl(
    private val tabsFormatter: TabsFormatter,
) : TabsRepository {
    override fun getView(): View {
        val vo = tabsFormatter.format()

        return TabsView(
            vo = vo,
        )
    }
}