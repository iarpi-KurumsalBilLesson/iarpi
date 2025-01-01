package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.control.UnitEntity

data class UnitDto(
    var id: Long?,
    val unitCode: String,
    val unitText: String,
    val isMainUnit: Boolean,
    val mainUnitCode: String,
    val companyId: Long?
)
