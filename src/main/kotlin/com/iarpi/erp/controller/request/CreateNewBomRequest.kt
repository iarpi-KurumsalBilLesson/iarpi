package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.BomDto

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
