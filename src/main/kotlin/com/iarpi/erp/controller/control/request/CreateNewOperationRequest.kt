package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.OperationDto

data class CreateNewOperationRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewOperationRequest.convertToDto(): OperationDto {
    return OperationDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
