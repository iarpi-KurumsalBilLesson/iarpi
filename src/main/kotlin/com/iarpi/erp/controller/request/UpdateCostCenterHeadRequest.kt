package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.CostCenterHeadEntity
import jakarta.validation.constraints.NotBlank

data class UpdateCostCenterHeadRequest(
    @field:NotBlank(message = "ShortText date cannot be blank")
    var shortText: String,

    @field:NotBlank(message = "LongText date cannot be blank")
    var longText: String,

    val baseCostCenterId: Long?,
)

fun UpdateCostCenterHeadRequest.applyUpdatesTo(entity: CostCenterHeadEntity, baseCostCenter : CostCenterHeadEntity?) = entity.apply {
    entity.costCenterText?.ccmlText = longText
    entity.costCenterText?.ccmsText = shortText
    entity.baseCostCenter = baseCostCenter
    return entity
}