package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.dto.control.CompanyDto
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank

data class CreateCompanyRequest(

    @field:NotBlank(message = "Com Code must not be empty")
    @field:Max(value = 4, message = "ComCode can be up to 4 characters")
    val comCode: String,

    @field:NotBlank(message = "Com Text must not be empty")
    @field:Max(value = 4, message = "ComCode can be too long")
    val comText: String
)

fun CreateCompanyRequest.convertToDto(): CompanyDto {
    return CompanyDto(
        comCode = this.comCode.uppercase(),
        comText = this.comText
    )
}
