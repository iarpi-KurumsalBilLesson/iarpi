package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.MaterialControlDto

data class UpdateMaterialRequest(
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateMaterialRequest.convertToDto(): MaterialControlDto {
    return MaterialControlDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
