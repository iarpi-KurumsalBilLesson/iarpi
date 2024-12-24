package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.UnitEntity

data class UnitDto(
    var id: Long?,
    val unitCode: String,
    val unitText: String,
    val isMainUnit: Boolean,
    val mainUnitCode: String
)

fun UnitDto.convertToEntity(): UnitEntity {
    return UnitEntity(
        null,
        this.unitCode,
        this.unitText,
        this.isMainUnit,
        this.mainUnitCode
    )
}

fun UnitDto.convertToEntity(unitCode: String): UnitEntity {
    return UnitEntity(
        null,
        unitCode,
        this.unitText,
        this.isMainUnit,
        this.mainUnitCode
    )
}
