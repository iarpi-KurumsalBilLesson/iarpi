package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.CountryDto

data class CreateCountryRequest(
    var comCode: String,
    var countryCode: String,
    var countryText: String
)

fun CreateCountryRequest.convertToDto(): CountryDto {
    return CountryDto(
        comCode,
        countryCode,
        countryText
    )
}
