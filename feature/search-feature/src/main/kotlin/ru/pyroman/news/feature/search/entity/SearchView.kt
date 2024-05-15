package ru.pyroman.news.feature.search.entity

import divkit.dsl.Container
import divkit.dsl.Custom
import divkit.dsl.Div
import divkit.dsl.color
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.core.expression
import divkit.dsl.custom
import divkit.dsl.customProps
import divkit.dsl.edgeInsets
import divkit.dsl.evaluate
import divkit.dsl.matchParentSize
import divkit.dsl.overlap
import divkit.dsl.scope.DivScope
import divkit.dsl.text
import divkit.dsl.top
import divkit.dsl.wrapContentSize
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.utils.setVariableVisibilityAction
import ru.pyroman.news.common.view.utils.visibilityDownloadActionWithExpression
import ru.pyroman.news.feature.search.SearchConstants.KEY_SEARCH_INPUT_TRIGGERED_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.KEY_SEARCH_INPUT_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.PATCH_SEARCH_RESULT_VISIBILITY_ACTION_ID
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_TRIGGERED_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_TRIGGER_VISIBILITY_ACTION_ID
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_LAYOUT_ID
import ru.pyroman.news.feature.searchresult.entity.SearchResultVo
import ru.pyroman.news.feature.searchresult.entity.searchResultView

class SearchView : View() {

    override val layoutId = SEARCH_LAYOUT_ID
    override fun DivScope.layout(): Div {
        return searchView()
    }

    private fun DivScope.searchView(): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            orientation = overlap,
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            items = listOf(
                search() + customProps(
                    alignmentVertical = top,
                    margins = edgeInsets(
                        top = 30,
                        bottom = 30,
                    ),
                    customProps = mapOf(
                        KEY_SEARCH_INPUT_VARIABLE_NAME to SEARCH_INPUT_VARIABLE_NAME,
                        KEY_SEARCH_INPUT_TRIGGERED_VARIABLE_NAME to SEARCH_INPUT_TRIGGERED_VARIABLE_NAME,
                    )
                ),
                searchTriggerView(),
                searchResultContainer() + containerProps(
                    margins = edgeInsets(
                        top = 100,
                    )
                ),
            )
        )
    }

    private fun DivScope.search(): Custom {
        return custom(
            customType = "search",
            width = matchParentSize(),
            height = wrapContentSize(),
        )
    }

    private fun DivScope.searchResultContainer(): Container {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            items = listOf(
                searchResultView(
                    vo = SearchResultVo(emptyList())
                )
            )
        )
    }

    private fun DivScope.searchTriggerView(): Div {
        return text(
            text = "Searching...",
            textColor = color("#00000000"),
            width = wrapContentSize(),
            height = wrapContentSize(),
            visibilityActions = listOf(
                setVariableVisibilityAction(
                    logId = SEARCH_INPUT_TRIGGER_VISIBILITY_ACTION_ID,
                    variableName = SEARCH_INPUT_TRIGGERED_VARIABLE_NAME,
                    value = false,
                ),
                visibilityDownloadActionWithExpression(
                    logId = PATCH_SEARCH_RESULT_VISIBILITY_ACTION_ID,
                    urlExpression = "patch/search-result?searchInput=@{$SEARCH_INPUT_VARIABLE_NAME}"
                )
            ),
        ).evaluate(
            visibility = expression("@{$SEARCH_INPUT_TRIGGERED_VARIABLE_NAME && len($SEARCH_INPUT_VARIABLE_NAME) > 0 ? 'visible' : 'gone'}")
        )
    }
}