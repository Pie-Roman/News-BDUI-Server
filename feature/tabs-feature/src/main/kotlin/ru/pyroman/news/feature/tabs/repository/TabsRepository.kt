package ru.pyroman.news.feature.tabs.repository

import ru.pyroman.news.common.view.View

internal interface TabsRepository {

    fun getView(): View
}