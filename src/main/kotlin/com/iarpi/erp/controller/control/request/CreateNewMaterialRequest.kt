package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.MaterialControlDto

data class CreateNewMaterialRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewMaterialRequest.convertToDto(): MaterialControlDto {
    return MaterialControlDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}

