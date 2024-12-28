package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.CompanyDto

data class CreateCompanyRequest(val comCode: String, val comText: String)

fun CreateCompanyRequest.convertToDto(): CompanyDto {
    return CompanyDto(
        comCode = this.comCode.uppercase(),
        comText = this.comText
    )
}
