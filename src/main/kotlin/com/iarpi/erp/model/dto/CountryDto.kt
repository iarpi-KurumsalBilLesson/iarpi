package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.CountryEntity
import com.iarpi.erp.model.entity.CountryId

class CountryDto(
    val comCode: String,
    val countryCode: String,
    val countryText: String
)

fun CountryDto.convertToEntity(company: CompanyDto): CountryEntity {
    val id = CountryId(comCode = this.comCode, this.countryCode)
    return CountryEntity(
        id = id,
        countryText = this.countryText,
        comCode = company.convertToEntity()
    )
}
