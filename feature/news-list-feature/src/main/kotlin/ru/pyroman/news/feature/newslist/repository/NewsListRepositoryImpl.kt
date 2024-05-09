package ru.pyroman.news.feature.newslist.repository

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.newslist.entity.NewsListView

internal class NewsListRepositoryImpl : NewsListRepository {

    override fun getView(): View {
        return NewsListView()
    }
}