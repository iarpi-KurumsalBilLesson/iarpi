package com.iarpi.erp.controller

import com.iarpi.erp.model.dto.UnitDto

data class CreateNewUnitRequest(
    val unitCode: String,
    val unitText: String,
    val isMainUnit: Boolean,
    val mainUnitCode: String
)

fun CreateNewUnitRequest.convertToDto(): UnitDto {
    return UnitDto(
        null,
        this.unitCode,
        this.unitText,
        this.isMainUnit,
        this.mainUnitCode
    )
}
