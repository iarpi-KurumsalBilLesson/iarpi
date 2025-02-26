package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.BomDto

data class CreateNewBomRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewBomRequest.convertToDto(): BomDto {
    return BomDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
