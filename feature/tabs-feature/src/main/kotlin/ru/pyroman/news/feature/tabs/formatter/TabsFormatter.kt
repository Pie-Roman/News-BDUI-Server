package ru.pyroman.news.feature.tabs.formatter

import divkit.dsl.Url
import ru.pyroman.news.feature.tabs.TabsConstants
import ru.pyroman.news.feature.tabs.entity.TabBarItemStateVo
import ru.pyroman.news.feature.tabs.entity.TabBarItemVo
import ru.pyroman.news.feature.tabs.entity.TabContainerStateVo
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
        val tabBarItemVo = formatNewsListTabBarItem()
        val tabContainerStateVo = formatNewsListTabContainerState()

        return TabVo(
            tabBarItemVo = tabBarItemVo,
            tabContainerStateVo = tabContainerStateVo,
        )
    }

    private fun formatNewsListTabBarItem(): TabBarItemVo {
        val selectedState = TabBarItemStateVo(
            id = TabsConstants.NEWS_LIST_TAB_BAR_ITEM_SELECTED_STATE_ID,
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_BAR_ITEM_SELECTED_IMAGE_URL),
        )

        val unselectedState = TabBarItemStateVo(
            id = TabsConstants.NEWS_LIST_TAB_BAR_ITEM_UNSELECTED_STATE_ID,
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_BAR_ITEM_UNSELECTED_IMAGE_URL),
        )

        return TabBarItemVo(
            id = TabsConstants.NEWS_LIST_TAB_BAR_ITEM_STATE_ID,
            selectedState = selectedState,
            unselectedState = unselectedState,
        )
    }

    private fun formatNewsListTabContainerState(): TabContainerStateVo {
        return TabContainerStateVo(
            id = TabsConstants.NEWS_LIST_TAB_LAYOUT_ID,
            stateId = TabsConstants.NEWS_LIST_TAB_STATE_ID,
            downloadActionId = TabsConstants.NEWS_LIST_TAB_VISIBILITY_ACTION_ID,
            downloadUrl = Url.create("patch/news-list"),
        )
    }
}