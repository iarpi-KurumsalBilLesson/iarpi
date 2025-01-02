package com.iarpi.erp.model.dto

import java.math.BigDecimal
import java.time.LocalDate

data class MaterialHeadDto(
    val id: Long?,
    val docNum: String,
    val matDocFrom: LocalDate,
    val matDocUntil: LocalDate,
    val supplyTypeName: String,
    val netWeight: BigDecimal?,
    val brutWeight: BigDecimal?,
    val bomName: String?,
    val routeName: String?,
    val deletedName: String?,
    val passiveName: String?,
    val companyName: String?,
    val materialTypeName: String?,
    val stockUnitName: String?,
    val netWeightUnitName: String?,
    val brutWeightUnitName: String?,
    val shortText: String?,
    val longText: String?,

    )
