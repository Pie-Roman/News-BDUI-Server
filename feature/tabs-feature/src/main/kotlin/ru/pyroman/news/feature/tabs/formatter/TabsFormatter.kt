package ru.pyroman.news.feature.tabs.formatter

import divkit.dsl.Url
import ru.pyroman.news.feature.tabs.TabsConstants
import ru.pyroman.news.feature.tabs.entity.TabStateVo
import ru.pyroman.news.feature.tabs.entity.TabVo
import ru.pyroman.news.feature.tabs.entity.TabsVo

internal class TabsFormatter {

    fun format(): TabsVo {
        val tabs = buildList {
            add(formatNewsListTab())
        }

        return TabsVo(
            tabs = tabs,
        )
    }

    private fun formatNewsListTab(): TabVo {
        val selectedState = TabStateVo(
            id = TabsConstants.NEWS_LIST_TAB_SELECTED_STATE_ID,
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_SELECTED_IMAGE_URL),
        )

        val unselectedState = TabStateVo(
            id = TabsConstants.NEWS_LIST_TAB_UNSELECTED_STATE_ID,
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_UNSELECTED_IMAGE_URL),
        )

        return TabVo(
            id = TabsConstants.NEWS_LIST_TAB_STATE_ID,
            selectedState = selectedState,
            unselectedState = unselectedState,
        )
    }
}