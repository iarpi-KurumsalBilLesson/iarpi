package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.CostCenterDto

data class CreateNewCostCenterRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun CreateNewCostCenterRequest.convertToDto(): CostCenterDto {
    return CostCenterDto(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive
    )
}
