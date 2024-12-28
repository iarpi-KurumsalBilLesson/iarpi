package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.OperationDto

data class UpdateOperationRequest (
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateOperationRequest.convertToDto(): OperationDto {
    return OperationDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
