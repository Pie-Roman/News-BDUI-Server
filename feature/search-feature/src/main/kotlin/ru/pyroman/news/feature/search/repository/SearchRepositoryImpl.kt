package ru.pyroman.news.feature.search.repository

import ru.pyroman.news.common.view.View
import ru.pyroman.news.feature.search.entity.SearchView

internal class SearchRepositoryImpl : SearchRepository {

    override fun getView(): View {
        return SearchView()
    }
}