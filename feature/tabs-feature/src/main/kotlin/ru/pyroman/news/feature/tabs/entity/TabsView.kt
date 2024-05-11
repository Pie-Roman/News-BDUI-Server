package ru.pyroman.news.feature.tabs.entity


import divkit.dsl.Container
import divkit.dsl.Div
import divkit.dsl.Image
import divkit.dsl.Url
import divkit.dsl.bottom
import divkit.dsl.center
import divkit.dsl.color
import divkit.dsl.container
import divkit.dsl.containerProps
import divkit.dsl.data
import divkit.dsl.divan
import divkit.dsl.edgeInsets
import divkit.dsl.fixedSize
import divkit.dsl.horizontal
import divkit.dsl.image
import divkit.dsl.matchParentSize
import divkit.dsl.overlap
import divkit.dsl.scope.DivScope
import divkit.dsl.singleRoot
import divkit.dsl.solidBackground
import divkit.dsl.space_between
import divkit.dsl.state
import divkit.dsl.stateItem
import divkit.dsl.wrapContentSize
import ru.pyroman.news.common.view.View
import ru.pyroman.news.common.view.ViewData
import ru.pyroman.news.common.view.utils.visibilityDownloadAction
import ru.pyroman.news.feature.tabs.TabsConstants

class TabsView(
    val vo: TabsVo,
) : View {

    override fun getData(): ViewData {
        val divan = divan {
            data(
                logId = TabsConstants.TABS_LAYOUT_ID,
                states = singleRoot(
                    tabsView(tabsVo = vo)
                )
            )
        }

        return ViewData.Factory.create(
            divan = divan,
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
            contentAlignmentHorizontal = space_between,
            contentAlignmentVertical = center,
            background = listOf(solidBackground(color = color("#FFFFFF"))),
            paddings = edgeInsets(
                left = 16,
                right = 16,
            ),
            items = tabsVo.tabs.map { tabVo ->
                tabsBarItem(tabVo.tabBarItemVo)
            },
        )
    }

    private fun DivScope.tabsBarItem(vo: TabBarItemVo): Div {
        return state(
            id = vo.id,
            width = wrapContentSize(),
            height = wrapContentSize(),
            states = listOf(
                stateItem(
                    stateId = vo.selectedState.id,
                    div = tabsBarItemImage(vo.selectedState.imageUrl)
                ),
                stateItem(
                    stateId = vo.unselectedState.id,
                    div = tabsBarItemImage(vo.unselectedState.imageUrl),
                ),
            ),
        )
    }

    private fun DivScope.tabsBarItemImage(imageUrl: Url): Image {
        return image(
            width = fixedSize(24),
            height = fixedSize(24),
            imageUrl = imageUrl,
            margins = edgeInsets(
                all = 16,
            )
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
            }
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
}