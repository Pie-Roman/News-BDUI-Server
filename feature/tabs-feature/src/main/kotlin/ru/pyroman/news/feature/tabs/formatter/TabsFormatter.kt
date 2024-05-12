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
            add(formatSearchTab())
        }

        return TabsVo(
            tabs = tabs,
            selectedTabId = TabsConstants.NEWS_LIST_TAB_ID,
        )
    }

    private fun formatNewsListTab(): TabVo {
        val tabBarItemVo = formatNewsListTabBarItem()
        val tabContainerStateVo = formatNewsListTabContainerState()

        return TabVo(
            id = TabsConstants.NEWS_LIST_TAB_ID,
            tabBarItemVo = tabBarItemVo,
            tabContainerStateVo = tabContainerStateVo,
        )
    }

    private fun formatNewsListTabBarItem(): TabBarItemVo {
        val selectedState = TabBarItemStateVo(
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_BAR_ITEM_SELECTED_IMAGE_URL),
        )

        val unselectedState = TabBarItemStateVo(
            imageUrl = Url.create(TabsConstants.NEWS_LIST_TAB_BAR_ITEM_UNSELECTED_IMAGE_URL),
        )

        return TabBarItemVo(
            selectedState = selectedState,
            unselectedState = unselectedState,
        )
    }

    private fun formatNewsListTabContainerState(): TabContainerStateVo {
        val id = TabsConstants.NEWS_LIST_TAB_LAYOUT_ID

        return TabContainerStateVo(
            id = id,
            stateId = TabsConstants.NEWS_LIST_TAB_STATE_ID,
            downloadActionId = TabsConstants.NEWS_LIST_TAB_VISIBILITY_ACTION_ID,
            downloadUrl = Url.create("patch/news-list?id=$id"),
        )
    }

    private fun formatSearchTab(): TabVo {
        val tabBarItemVo = formatSearchTabBarItem()
        val tabContainerStateVo = formatSearchTabContainerState()

        return TabVo(
            id = TabsConstants.SEARCH_TAB_ID,
            tabBarItemVo = tabBarItemVo,
            tabContainerStateVo = tabContainerStateVo,
        )
    }

    private fun formatSearchTabBarItem(): TabBarItemVo {
        val selectedState = TabBarItemStateVo(
            imageUrl = Url.create(TabsConstants.SEARCH_TAB_BAR_ITEM_SELECTED_IMAGE_URL),
        )
        val unselectedState = TabBarItemStateVo(
            imageUrl = Url.create(TabsConstants.SEARCH_TAB_BAR_ITEM_UNSELECTED_IMAGE_URL),
        )

        return TabBarItemVo(
            selectedState = selectedState,
            unselectedState = unselectedState,
        )
    }

    private fun formatSearchTabContainerState(): TabContainerStateVo {
        val id = TabsConstants.SEARCH_TAB_LAYOUT_ID

        return TabContainerStateVo(
            id = id,
            stateId = TabsConstants.SEARCH_TAB_STATE_ID,
            downloadActionId = TabsConstants.SEARCH_TAB_VISIBILITY_ACTION_ID,
            downloadUrl = Url.create("patch/search?id=$id"),
        )
    }
}