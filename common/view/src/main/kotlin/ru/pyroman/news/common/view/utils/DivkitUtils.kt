package ru.pyroman.news.common.view.utils

import divkit.dsl.Action
import divkit.dsl.Url
import divkit.dsl.VisibilityAction
import divkit.dsl.action
import divkit.dsl.core.expression
import divkit.dsl.evaluate
import divkit.dsl.scope.DivScope
import divkit.dsl.url
import divkit.dsl.visibilityAction

fun DivScope.setStateAction(
    logId: String,
    stateId: String,
    stateItemId: String
): Action {
    return action(
        logId = logId,
        url = url("div-action://set_state?state_id=0/$stateId/$stateItemId")
    )
}

fun DivScope.setStateActionWithExpression(
    logId: String,
    stateId: String,
    stateItemId: String,
): Action {
    return action(
        logId = logId,
    ).evaluate(
        url = expression("div-action://set_state?state_id=0/$stateId/$stateItemId")
    )
}

fun DivScope.setVariableAction(
    logId: String,
    variableName: String,
    value: Any,
): Action {
    return action(
        logId = logId,
    ).evaluate(
        url = expression("div-action://set_variable?name=$variableName&value=$value")
    )
}

fun DivScope.visibilityDownloadAction(
    logId: String,
    url: Url,
    logLimit: Int? = 0,
): VisibilityAction {
    return visibilityAction(
        logId = logId,
        url = url(makeDownloadUrl(url.toString())),
        logLimit = logLimit,
    )
}

fun DivScope.downloadAction(
    logId: String,
    url: Url,
): Action {
    return action(
        logId = logId,
        url = url(makeDownloadUrl(url.toString())),
    )
}

private fun DivScope.makeDownloadUrl(url: String) = "div-action://download?url=$url"

fun DivScope.downloadActionWithExpression(
    logId: String,
    urlExpression: String,
): Action {
    return action(
        logId = logId,
    ).evaluate(
        url = expression(makeDownloadUrl(urlExpression)),
    )
}