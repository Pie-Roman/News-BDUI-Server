package ru.pyroman.news.feature.newslist.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.common.view.ViewPatchData
import ru.pyroman.news.feature.newslist.service.NewsListService

@RestController
class NewsListController(
    private val service: NewsListService,
) {

    @GetMapping("/news-list")
    fun getViewData(): ViewData {
        return service.getView().getData()
    }

    @GetMapping("/patch/news-list")
    fun getViewPatchData(): ViewPatchData {
        return service.getView().getPatchData()
    }
}