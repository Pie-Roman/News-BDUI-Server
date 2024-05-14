package ru.pyroman.news.feature.tabs.entity


import divkit.dsl.Action
import divkit.dsl.Container
import divkit.dsl.Div
import divkit.dsl.Image
import divkit.dsl.Variable
import divkit.dsl.bottom
import divkit.dsl.center
import divkit.dsl.color
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.core.expression
import divkit.dsl.edgeInsets
import divkit.dsl.evaluate
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
import ru.pyroman.news.common.view.utils.setVariableAction
import ru.pyroman.news.common.view.utils.visibilityDownloadAction
import ru.pyroman.news.feature.tabs.TabsConstants
import ru.pyroman.news.feature.tabs.TabsConstants.SELECTED_TAB_ID_VARIABLE_NAME

class TabsView(
    val vo: TabsVo,
) : View() {

    override val layoutId = TabsConstants.TABS_LAYOUT_ID

    context (DivScope)
    override val variables: List<Variable>
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
            background = listOf(solidBackground(color = color("#FFFFFF"))),
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
        val selectedState = tabBarItemVo.selectedState
        val unselectedState = tabBarItemVo.unselectedState

        return container(
            width = wrapContentSize(),
            height = wrapContentSize(),
            actions = switchTabActions(id),
            items = listOf(
                tabsBarItemImage(
                    imageUrlExpression = "@{$SELECTED_TAB_ID_VARIABLE_NAME == '$id' ? '${selectedState.imageUrl}' : '${unselectedState.imageUrl}'}"
                )
            )
        )
    }

    private fun DivScope.tabsBarItemImage(
        imageUrlExpression: String,
    ): Image {
        return image(
            width = fixedSize(24),
            height = fixedSize(24),
            margins = edgeInsets(
                all = 16,
            ),
        ).evaluate(
            imageUrl = expression(imageUrlExpression),
        )
    }

    private fun DivScope.tabContainer(tabsVo: TabsVo): Div {
        return state(
            width = matchParentSize(),
            height = matchParentSize(),
            stateIdVariable = SELECTED_TAB_ID_VARIABLE_NAME,
            states = tabsVo.tabs.map { tabVo ->
                stateItem(
                    stateId = tabVo.id,
                    div = tab(tabVo.tabContainerVo),
                )
            },
        )
    }

    private fun DivScope.tab(tabContainerVo: TabContainerVo): Div {
        return container(
            width = matchParentSize(),
            height = matchParentSize(),
            id = tabContainerVo.layoutId,
            visibilityActions = listOf(
                visibilityDownloadAction(
                    logId = tabContainerVo.downloadActionId,
                    url = tabContainerVo.downloadUrl,
                )
            ),
        )
    }

    private fun DivScope.switchTabActions(newTabId: String): List<Action> {
        return buildList {
            add(setTabIdAction(newTabId))
        }
    }

    private fun DivScope.setTabIdAction(newTabId: String): Action {
        return setVariableAction(
            logId = "$SELECTED_TAB_ID_VARIABLE_NAME$newTabId",
            variableName = SELECTED_TAB_ID_VARIABLE_NAME,
            value = newTabId,
        )
    }
}