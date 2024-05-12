package ru.pyroman.news.feature.newslist.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewPatchData
import ru.pyroman.news.feature.newslist.service.NewsListService

@RestController
class NewsListController(
    private val service: NewsListService,
) {

    @GetMapping("/patch/news-list")
    fun getViewPatchData(
        @RequestParam("id") id: String,
    ): ViewPatchData {
        return service.getView().getPatchData(id)
    }
}