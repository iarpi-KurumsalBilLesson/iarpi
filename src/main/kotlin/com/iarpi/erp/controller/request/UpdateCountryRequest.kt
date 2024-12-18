package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.CountryDto

class UpdateCountryRequest(
    var comCode: String,
    var countryCode: String,
    var countryText: String
)

fun UpdateCountryRequest.convertToDto(): CountryDto {
    return CountryDto(
        comCode,
        countryCode,
        countryText
    )
}