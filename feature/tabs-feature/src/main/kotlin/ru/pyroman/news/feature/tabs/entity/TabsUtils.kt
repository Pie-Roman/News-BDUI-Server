package ru.pyroman.news.feature.tabs.entity

internal val String.tabBarItemStateId
    get() = "${this}_tabBarItemState"

internal val String.tabBarItemSelectedStateId
    get() = "${this}_tabBarItemSelectedState"

internal val String.tabBarItemUnselectedStateId
    get() = "${this}_tabBarItemUnselectedState"