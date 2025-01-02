package com.iarpi.erp.model.dto

import java.math.BigDecimal
import java.time.LocalDate

data class BomHeadDto (
    val id: Long?,
    val bomDocNumber: String,
    val bomDocFrom : LocalDate,
    val bomDocUntil : LocalDate,
    val quantity : BigDecimal,
    val drawNum : String?,
    val materialTypeName : String,
    val bomTypeName : String,
    val companyName : String,
    val materialHeadName : String,
)
