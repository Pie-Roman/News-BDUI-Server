package ru.pyroman.news.feature.newslist.service

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.newslist.repository.NewsListRepository

internal class NewsListServiceImpl(
    private val newsListRepository: NewsListRepository,
) : NewsListService {

    override fun getView(): View {
        return newsListRepository.getView()
    }
}