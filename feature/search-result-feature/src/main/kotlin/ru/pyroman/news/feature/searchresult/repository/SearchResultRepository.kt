package ru.pyroman.news.feature.searchresult.repository

import ru.pyroman.news.common.view.View

interface SearchResultRepository {

    fun getView(searchInput: String): View
}