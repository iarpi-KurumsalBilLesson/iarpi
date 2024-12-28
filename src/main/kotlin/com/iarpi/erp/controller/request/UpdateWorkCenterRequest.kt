package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.WorkCenterDto

data class UpdateWorkCenterRequest(
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateWorkCenterRequest.convertToDto(): WorkCenterDto {
    return WorkCenterDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
