package ru.pyroman.news.feature.tabs.entity

import divkit.dsl.Url

class TabContainerVo(
    val layoutId: String,
    val downloadActionId: String,
    val downloadUrl: Url,
)