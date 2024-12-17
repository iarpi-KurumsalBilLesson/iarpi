package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.CompanyEntity

data class CompanyDto(val comCode: String, val comText: String)

fun CompanyDto.convertToEntity(): CompanyEntity {
    return CompanyEntity(
        comCode = this.comCode.uppercase(),
        comText = this.comText
    )
}
