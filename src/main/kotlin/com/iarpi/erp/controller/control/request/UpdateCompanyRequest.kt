package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.CompanyDto
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size
import kotlin.math.max

data class UpdateCompanyRequest(
    @field:NotBlank(message = "Com Text must not be empty")
    @field:Size(max = 80, message = "ComCode can be too long")
    var comText: String
)

fun UpdateCompanyRequest.convertToDto(): CompanyDto {
    return CompanyDto(
        comCode = "DEFAULT",
        comText = this.comText
    )
}