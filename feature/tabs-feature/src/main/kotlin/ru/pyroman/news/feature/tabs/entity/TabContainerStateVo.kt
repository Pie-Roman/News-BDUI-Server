package ru.pyroman.news.feature.tabs.entity

import divkit.dsl.Url

class TabContainerStateVo(
    val id: String,
    val stateId: String,
    val downloadActionId: String,
    val downloadUrl: Url,
)