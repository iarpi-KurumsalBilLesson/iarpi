package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.CompanyEntity

data class CreateNewBomRequest(
    var companyId: Long,
    var docType: String,
    var docText: String,
    var isPassive: Boolean,
)

fun CreateNewBomRequest.convertToEntity(company: CompanyEntity): BomEntity {
    return BomEntity(
        null,
        this.docType,
        this.docText,
        this.isPassive,
        company = company
    )
}
