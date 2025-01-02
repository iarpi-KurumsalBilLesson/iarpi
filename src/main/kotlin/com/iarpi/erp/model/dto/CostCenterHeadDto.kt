package com.iarpi.erp.model.dto

import java.time.LocalDate

data class CostCenterHeadDto(
    val id: Long?,
    val docNum: String,
    val ccmDocFrom: LocalDate,
    val ccmDocUntil: LocalDate,
    val deletedName: String?,
    val passiveName: String?,
    val companyName: String?,
    val shortText: String?,
    val longText: String?,
    val ccmType: String?,
    val baseCostCenterName: String?,
)
