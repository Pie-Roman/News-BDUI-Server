package ru.pyroman.news.feature.search.service

import org.springframework.stereotype.Service
import ru.pyroman.news.common.view.View

@Service
interface SearchService {

    fun getView(): View
}