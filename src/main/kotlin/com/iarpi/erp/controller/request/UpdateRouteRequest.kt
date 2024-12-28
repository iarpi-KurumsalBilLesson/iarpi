package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.RouteDto

data class UpdateRouteRequest(
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateRouteRequest.convertToDto(): RouteDto {
    return RouteDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
