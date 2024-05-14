package ru.pyroman.news.feature.search.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewPatchData
import ru.pyroman.news.feature.search.service.SearchService

@RestController
class SearchController(
    private val searchService: SearchService,
) {

    @GetMapping("/patch/search")
    fun getViewPatchData(
        @RequestParam("id") id: String,
    ): ViewPatchData {
        return searchService.getView().getPatchData(id)
    }
}