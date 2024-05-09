package ru.pyroman.news.feature.newslist.entity

import divkit.dsl.container
import divkit.dsl.data
import divkit.dsl.divan
import divkit.dsl.singleRoot
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.feature.newslist.NewsListConstants.NEWS_LIST_LAYOUT_ID

internal class NewsListView : View {
    override fun getData(): ViewData {

        val divan = divan {
            data(
                logId = NEWS_LIST_LAYOUT_ID,
                states = singleRoot(
                    div = container(

                    )
                )
            )
        }

        return ViewData.Factory.create(
            divan = divan,
        )
    }
}