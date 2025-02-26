package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.CostCenterDto

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
