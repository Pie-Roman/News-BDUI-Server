package ru.pyroman.news.feature.newslist.service

import org.springframework.stereotype.Service
import ru.pyroman.news.common.view.View

@Service
interface NewsListService {

    fun getView(): View
}