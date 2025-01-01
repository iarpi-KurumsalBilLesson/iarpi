package com.iarpi.erp.controller.control.request

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateCompanyRequest(
    @field:NotBlank(message = "Com Text must not be empty")
    @field:Size(max = 80, message = "ComCode can be too long")
    var comText: String
)
