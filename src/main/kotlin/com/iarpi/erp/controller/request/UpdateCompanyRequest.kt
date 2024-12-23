package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.CompanyDto

data class UpdateCompanyRequest(var comText: String)

fun UpdateCompanyRequest.convertToDto(): CompanyDto {
    return CompanyDto(
        comCode = "DEFAULT",
        comText = this.comText
    )
}