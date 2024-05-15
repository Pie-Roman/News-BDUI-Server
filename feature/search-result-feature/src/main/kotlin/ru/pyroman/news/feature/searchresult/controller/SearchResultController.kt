package ru.pyroman.news.feature.searchresult.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewPatchData
import ru.pyroman.news.feature.searchresult.SearchResultConstants.SEARCH_RESULT_CONTAINER_LAYOUT_ID
import ru.pyroman.news.feature.searchresult.service.SearchResultService

@RestController
class SearchResultController(
    private val searchResultService: SearchResultService,
) {

    @GetMapping("/patch/search-result")
    fun getViewPatchData(
        @RequestParam("searchInput") searchInput: String,
    ): ViewPatchData {
        return searchResultService.getView(searchInput).getPatchData(SEARCH_RESULT_CONTAINER_LAYOUT_ID)
    }
}