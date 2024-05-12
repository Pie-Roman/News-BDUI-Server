package ru.pyroman.news.feature.tabs.entity


import divkit.dsl.Action
import divkit.dsl.Container
import divkit.dsl.Div
import divkit.dsl.Image
import divkit.dsl.Url
import divkit.dsl.Variable
import divkit.dsl.bottom
import divkit.dsl.center
import divkit.dsl.color
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.edgeInsets
import divkit.dsl.fixedSize
import divkit.dsl.horizontal
import divkit.dsl.image
import divkit.dsl.matchParentSize
import divkit.dsl.overlap
import divkit.dsl.scope.DivScope
import divkit.dsl.solidBackground
import divkit.dsl.space_around
import divkit.dsl.state
import divkit.dsl.stateItem
import divkit.dsl.stringVariable
import divkit.dsl.wrapContentSize
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.utils.setStateAction
import ru.pyroman.news.common.view.utils.setStateActionWithExpression
import ru.pyroman.news.common.view.utils.setVariableAction
import ru.pyroman.news.common.view.utils.visibilityDownloadAction
import ru.pyroman.news.feature.tabs.TabsConstants
import ru.pyroman.news.feature.tabs.TabsConstants.SELECTED_TAB_ID_VARIABLE_NAME

class TabsView(
    val vo: TabsVo,
) : View() {

    override val layoutId = TabsConstants.TABS_LAYOUT_ID

    override val DivScope.variables: List<Variable>
        get() = listOf(
            stringVariable(
                name = SELECTED_TAB_ID_VARIABLE_NAME,
                value = vo.selectedTabId,
            ),
        )

    override fun DivScope.layout(): Div {
        return tabsView(
            tabsVo = vo,
        )
    }

    private fun DivScope.tabsView(tabsVo: TabsVo): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            orientation = overlap,
            items = listOf(
                tabContainer(tabsVo = tabsVo),
                tabsBar(tabsVo = tabsVo) + containerProps(
                    alignmentVertical = bottom,
                )
            )
        )
    }

    private fun DivScope.tabsBar(tabsVo: TabsVo): Container {
        return container(
            width = matchParentSize(),
            height = wrapContentSize(),
            orientation = horizontal,
            contentAlignmentHorizontal = space_around,
            contentAlignmentVertical = center,
            background = listOf(solidBackground(color = color("#FFFFFF"))),
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            items = tabsVo.tabs.map { tabVo ->
                tabsBarItem(tabVo)
            },
        )
    }

    private fun DivScope.tabsBarItem(vo: TabVo): Div {
        val id = vo.id
        val tabBarItemVo = vo.tabBarItemVo

        return container(
            width = wrapContentSize(),
            height = wrapContentSize(),
            actions = switchTabActions(id),
            items = listOf(
                state(
                    id = id.tabBarItemStateId,
                    width = wrapContentSize(),
                    height = wrapContentSize(),
                    states = listOf(
                        stateItem(
                            stateId = id.tabBarItemUnselectedStateId,
                            div = tabsBarItemImage(tabBarItemVo.unselectedState.imageUrl),
                        ),
                        stateItem(
                            stateId = id.tabBarItemSelectedStateId,
                            div = tabsBarItemImage(tabBarItemVo.selectedState.imageUrl)
                        ),
                    ),
                ),
            )
        )
    }

    private fun DivScope.tabsBarItemImage(
        imageUrl: Url,
    ): Image {
        return image(
            width = fixedSize(24),
            height = fixedSize(24),
            imageUrl = imageUrl,
            margins = edgeInsets(
                all = 16,
            ),
        )
    }

    private fun DivScope.tabContainer(tabsVo: TabsVo): Div {
        return state(
            width = matchParentSize(),
            height = matchParentSize(),
            states = tabsVo.tabs.map { tabVo ->
                stateItem(
                    stateId = tabVo.tabContainerStateVo.stateId,
                    div = tab(tabVo.tabContainerStateVo),
                )
            },
        )
    }

    private fun DivScope.tab(tabContainerStateVo: TabContainerStateVo): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            id = tabContainerStateVo.id,
            visibilityActions = listOf(
                visibilityDownloadAction(
                    logId = tabContainerStateVo.downloadActionId,
                    url = tabContainerStateVo.downloadUrl,
                )
            ),
        )
    }

    private fun DivScope.switchTabActions(newTabId: String): List<Action> {
        return listOf(
            unselectTabAction(),
            setVariableAction(
                logId = "$SELECTED_TAB_ID_VARIABLE_NAME$newTabId",
                variableName = SELECTED_TAB_ID_VARIABLE_NAME,
                value = newTabId,
            ),
            selectTabStateAction(newTabId),
        )
    }

    private fun DivScope.unselectTabAction(): Action {
        return setStateActionWithExpression(
            logId = "${SELECTED_TAB_ID_VARIABLE_NAME}_unselect_state",
            stateId = "@{$SELECTED_TAB_ID_VARIABLE_NAME}".tabBarItemStateId,
            stateItemId = "@{$SELECTED_TAB_ID_VARIABLE_NAME}".tabBarItemUnselectedStateId,
        )
    }

    private fun DivScope.selectTabStateAction(tabId: String): Action {
        return setStateAction(
            logId = "${tabId}_select_state",
            stateId = tabId.tabBarItemStateId,
            stateItemId = tabId.tabBarItemSelectedStateId,
        )
    }
}