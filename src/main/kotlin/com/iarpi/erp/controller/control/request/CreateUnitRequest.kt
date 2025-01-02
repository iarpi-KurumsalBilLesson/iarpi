package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUnitRequest(
    @field:NotBlank(message = "Birim kodu boş olamaz")
    @field:Size(max = 3, message = "Birim kodu 3 karakterden uzun olamaz")
    val unitCode: String,

    @field:NotBlank(message = "Birim metni boş olamaz")
    @field:Size(max = 80, message = "Birim metni 80 karakterden uzun olamaz")
    val unitText: String,

    val isMainUnit: Boolean = false,

    @field:NotBlank(message = "Ana birim kodu boş olamaz")
    @field:Size(max = 3, message = "Ana birim kodu 3 karakterden uzun olamaz")
    val mainUnitCode: String,

    @field:NotNull(message = "Şirket bilgisi boş olamaz")
    val companyId: Long
)

fun CreateUnitRequest.convertToEntity(company: CompanyEntity) = UnitEntity(
    id = null,
    unitCode = unitCode,
    unitText = unitText,
    isMainUnit = isMainUnit,
    mainUnitCode = mainUnitCode,
    company = company
)
