package com.iarpi.erp.controller.control.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateNewCompanyRequest(
    @field:NotBlank(message = "Şirket ismi boş olamaz")
    @field:Size(max = 4, message = "Şirket ismi 4 karakterden fazla olamaz")
    val comCode: String,

    @field:NotBlank(message = "Şirket açıklaması boş olamaz")
    @field:Size(max = 80, message = "Şirket açıklaması çok uzun olamaz")
    val comText: String
) 