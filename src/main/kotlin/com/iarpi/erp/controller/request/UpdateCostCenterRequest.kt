package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.CostCenterDto

data class UpdateCostCenterRequest(
    var docTypeText: String,
    var isPassive: Boolean
)

fun UpdateCostCenterRequest.convertToDto(): CostCenterDto {
    return CostCenterDto(
        null,
        "DEFAULT",
        this.docTypeText,
        this.isPassive
    )
}
