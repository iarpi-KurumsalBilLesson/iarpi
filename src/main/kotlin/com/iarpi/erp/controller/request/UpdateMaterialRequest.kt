package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.MaterialDto

data class UpdateMaterialRequest(
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateMaterialRequest.convertToDto(): MaterialDto {
    return MaterialDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
