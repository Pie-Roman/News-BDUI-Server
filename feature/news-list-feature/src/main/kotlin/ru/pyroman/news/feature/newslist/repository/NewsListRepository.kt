package ru.pyroman.news.feature.newslist.repository

import ru.pyroman.news.common.view.View

interface NewsListRepository {

    fun getView(): View
}