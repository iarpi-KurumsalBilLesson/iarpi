package com.iarpi.erp.controller.request

import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreateMaterialHeadRequest(

    @field:NotNull(value = "Company cannot be null")
    val companyId: Long,

    @field:NotNull(value = "Material cannot be null")
    val materialId: Long,

    @field:NotBlank(message = "Document number cannot be blank")
    val matDocNumber: String,

    @field:NotBlank(message = "Document date cannot be blank")
    val matDocFrom: LocalDate,

    @field:NotBlank(message = "Document date cannot be blank")
    val matDocUntil: LocalDate,

    @field:Min(0, message = "Supply type can only be 0 or 1")
    @field:Max(1, message = "Supply type can only be 0 or 1")
    val supplyType: Int,

    val newWeightId: Long,

    val netWeight: BigDecimal?,

    val brutWeightId: Long,

    val brutWeight: BigDecimal,

    val isBom: Int = 1,

    val isRoute: Int = 1,

    val isDeleted: Boolean = false,

    val isPassive: Boolean = false,
)
