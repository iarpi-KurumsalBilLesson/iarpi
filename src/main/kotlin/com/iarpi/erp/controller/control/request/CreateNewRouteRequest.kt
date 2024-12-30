package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.RouteDto

data class CreateNewRouteRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewRouteRequest.convertToDto(): RouteDto {
    return RouteDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
