package ru.pyroman.news.feature.search.repository

import ru.pyroman.news.common.view.View

interface SearchRepository {

    fun getView(): View
}