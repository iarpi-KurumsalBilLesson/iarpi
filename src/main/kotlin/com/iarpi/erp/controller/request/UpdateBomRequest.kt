package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.BomDto

data class UpdateBomRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateBomRequest.convertToDto(): BomDto {
    return BomDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
