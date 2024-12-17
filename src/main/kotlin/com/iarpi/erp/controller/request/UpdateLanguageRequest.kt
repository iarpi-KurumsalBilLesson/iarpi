package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.LanguageDto

class UpdateLanguageRequest(
    val comCode: String,
    val lanCode: String,
    val lanText: String
)

fun UpdateLanguageRequest.convertToDto(): LanguageDto {
    return LanguageDto(
        comCode = this.comCode.uppercase(),
        lanCode = this.lanCode.uppercase(),
        lanText = this.lanText
    )
}
