package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateUnitRequest(
    @field:NotBlank(message = "Unit text cannot be blank")
    @field:Size(max = 100, message = "Unit text cannot exceed 100 characters")
    val unitText: String,

    val isMainUnit: Boolean,

    @field:NotBlank(message = "Main unit code cannot be blank")
    @field:Size(max = 50, message = "Main unit code cannot exceed 50 characters")
    val mainUnitCode: String
)

fun UpdateUnitRequest.applyUpdatesTo(entity: UnitEntity) = entity.apply {
    unitText = this@applyUpdatesTo.unitText
    isMainUnit = this@applyUpdatesTo.isMainUnit
    mainUnitCode = this@applyUpdatesTo.mainUnitCode
}