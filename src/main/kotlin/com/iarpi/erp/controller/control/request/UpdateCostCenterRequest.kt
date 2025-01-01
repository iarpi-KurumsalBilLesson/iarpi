package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.CostCenterEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateCostCenterRequest(
    @field:NotBlank(message = "Doc Text must not be empty")
    @field:Size(max = 80, message = "Doc Text cannot be longer than 80 characters")
    val docText: String,

    val isPassive: Boolean
)

fun UpdateCostCenterRequest.applyUpdatesTo(entity: CostCenterEntity): CostCenterEntity {
    entity.docText = this.docText
    entity.isPassive = this.isPassive
    return entity
}
