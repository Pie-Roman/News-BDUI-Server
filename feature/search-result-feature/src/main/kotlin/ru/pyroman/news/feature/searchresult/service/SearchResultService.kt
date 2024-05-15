package ru.pyroman.news.feature.searchresult.service

import org.springframework.stereotype.Service
import ru.pyroman.news.common.view.View

@Service
interface SearchResultService {

    fun getView(searchInput: String): View
}