package ru.pyroman.news.feature.tabs.service

import org.springframework.stereotype.Service
import ru.pyroman.news.common.view.View

@Service
interface TabsService {

    fun getView(): View
}