package ru.pyroman.news.feature.searchResultresult.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewPatchData
import ru.pyroman.news.feature.searchresult.service.SearchResultService

@RestController
class SearchResultController(
    private val searchResultService: SearchResultService,
) {

    @GetMapping("/patch/search-result")
    fun getViewPatchData(
        @RequestParam("id") id: String,
        @RequestParam("searchInput") searchInput: String,
    ): ViewPatchData {
        return searchResultService.getView(searchInput).getPatchData(id)
    }
}