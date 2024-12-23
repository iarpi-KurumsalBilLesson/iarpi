package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.MaterialDto

data class CreateNewMaterialRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewMaterialRequest.convertToDto(): MaterialDto {
    return MaterialDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}

