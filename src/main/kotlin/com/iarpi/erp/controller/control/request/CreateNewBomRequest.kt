package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.BomEntity

data class CreateNewBomRequest(
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean,
)

fun CreateNewBomRequest.convertToEntity(): BomEntity{
    return BomEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}
