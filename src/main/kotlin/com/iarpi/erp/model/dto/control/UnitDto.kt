package com.iarpi.erp.model.dto.control

data class UnitDto(
    var id: Long?,
    val unitCode: String,
    val unitText: String,
    val isMainUnit: Boolean,
    val mainUnitCode: String,
    val companyId: Long?
)
