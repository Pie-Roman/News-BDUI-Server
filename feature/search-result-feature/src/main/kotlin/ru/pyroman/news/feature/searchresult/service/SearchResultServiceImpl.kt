package ru.pyroman.news.feature.searchresult.service

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.searchresult.repository.SearchResultRepository

internal class SearchResultServiceImpl(
    private val searchResultRepository: SearchResultRepository
) : SearchResultService {

    override fun getView(searchInput: String): View {
        return searchResultRepository.getView(searchInput)
    }
}