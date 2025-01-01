package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class CreateUnitRequest(
    @field:NotBlank(message = "Unit code cannot be blank")
    @field:Size(max = 50, message = "Unit code cannot exceed 50 characters")
    val unitCode: String,

    @field:NotBlank(message = "Unit text cannot be blank")
    @field:Size(max = 100, message = "Unit text cannot exceed 100 characters")
    val unitText: String,

    val isMainUnit: Boolean = false,

    @field:NotBlank(message = "Main unit code cannot be blank")
    @field:Size(max = 50, message = "Main unit code cannot exceed 50 characters")
    val mainUnitCode: String,

    @field:NotNull(message = "Company ID cannot be null")
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
