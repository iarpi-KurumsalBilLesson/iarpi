package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.UnitDto

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
