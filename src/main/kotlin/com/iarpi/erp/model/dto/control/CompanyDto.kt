package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.control.CompanyEntity

data class CompanyDto(var id: Long?, val comCode: String, val comText: String) {
    constructor(comCode: String, comText: String) : this(0, comCode, comText)
}

fun CompanyDto.convertToEntity(): CompanyEntity {
    return CompanyEntity(
        comCode = this.comCode.uppercase(),
        comText = this.comText
    )
}
