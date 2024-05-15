package ru.pyroman.news.feature.search.entity

import divkit.dsl.Custom
import divkit.dsl.Div
import divkit.dsl.container
import divkit.dsl.core.expression
import divkit.dsl.custom
import divkit.dsl.customProps
import divkit.dsl.edgeInsets
import divkit.dsl.evaluate
import divkit.dsl.matchParentSize
import divkit.dsl.scope.DivScope
import divkit.dsl.text
import divkit.dsl.vertical
import divkit.dsl.wrapContentSize
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.utils.setVariableVisibilityAction
import ru.pyroman.news.common.view.utils.visibilityDownloadActionWithExpression
import ru.pyroman.news.feature.search.SearchConstants.KEY_SEARCH_INPUT_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.PATCH_SEARCH_RESULT_VISIBILITY_ACTION_ID
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_TRIGGERED_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_TRIGGER_VISIBILITY_ACTION_ID
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_INPUT_VARIABLE_NAME
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_LAYOUT_ID
import ru.pyroman.news.feature.search.SearchConstants.SEARCH_RESULT_CONTAINER_LAYOUT_ID

class SearchView : View() {

    override val layoutId = SEARCH_LAYOUT_ID
    override fun DivScope.layout(): Div {
        return searchView()
    }

    private fun DivScope.searchView(): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            orientation = vertical,
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            items = listOf(
                search() + customProps(
                    margins = edgeInsets(
                        top = 30,
                        bottom = 30,
                    ),
                    customProps = mapOf(
                        KEY_SEARCH_INPUT_VARIABLE_NAME to SEARCH_INPUT_VARIABLE_NAME
                    )
                ),
                text(
                    width = wrapContentSize(),
                    height = wrapContentSize(),
                    text = "haha",
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
                    )
                ).evaluate(
                    visibility = expression("@{$SEARCH_INPUT_TRIGGERED_VARIABLE_NAME ? 'visible' : 'gone'}")
                ),
                searchResultContainer(),
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

    private fun DivScope.searchResultContainer(): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            items = listOf(
                container(
                    width = matchParentSize(),
                    height = matchParentSize(),
                    id = SEARCH_RESULT_CONTAINER_LAYOUT_ID,
                )
            )
        )
    }
}