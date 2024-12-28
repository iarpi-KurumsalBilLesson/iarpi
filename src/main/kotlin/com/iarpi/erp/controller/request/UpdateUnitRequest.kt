package com.iarpi.erp.controller.request

import com.iarpi.erp.model.dto.control.UnitDto

data class UpdateUnitRequest(
    val unitText: String,
    val isMainUnit: Boolean,
    val mainUnitCode: String
)

fun UpdateUnitRequest.convertToDto(): UnitDto {
    return UnitDto(
        null,
        "DEFAULT",
        this.unitText,
        this.isMainUnit,
        this.mainUnitCode
    )
}