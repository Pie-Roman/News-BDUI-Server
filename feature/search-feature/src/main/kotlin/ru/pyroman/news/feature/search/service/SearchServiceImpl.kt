package ru.pyroman.news.feature.search.service

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.search.repository.SearchRepository

internal class SearchServiceImpl(
    private val searchRepository: SearchRepository,
) : SearchService {

    override fun getView(): View {
        return searchRepository.getView()
    }
}