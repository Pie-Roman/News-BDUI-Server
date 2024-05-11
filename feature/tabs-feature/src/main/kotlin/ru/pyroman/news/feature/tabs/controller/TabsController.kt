package ru.pyroman.news.feature.tabs.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.feature.tabs.service.TabsService

@RestController
class TabsController(
    private val service: TabsService,
) {

    @GetMapping("/tabs")
    fun getViewData(): ViewData {
        return service.getView().getData()
    }
}