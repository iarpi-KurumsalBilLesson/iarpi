package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.WorkCenterDto

data class CreateNewWorkCenterRequest (
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewWorkCenterRequest.convertToDto(): WorkCenterDto {
    return WorkCenterDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
