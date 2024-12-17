package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.LanguageEntity
import com.iarpi.erp.model.entity.LanguageId

class LanguageDto(
    val comCode: String,
    val lanCode: String,
    val lanText: String
)

fun LanguageDto.convertToEntity(company: CompanyDto): LanguageEntity {
    val id = LanguageId(comCode = this.comCode, lanCode = this.lanCode)
    return LanguageEntity(
        id = id,
        lanText = this.lanText,
        comCode = company.convertToEntity()
    )
}
