package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.control.CostCenterEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CreateCostCenterRequest(
    @field:NotBlank(message = "Doc Type must not be empty")
    @field:Size(max = 4, message = "Doc Type cannot be longer than 25 characters")
    val docType: String,

    @field:NotBlank(message = "Doc Text must not be empty")
    @field:Size(max = 4, message = "Doc Text cannot be longer than 80 characters")
    val docText: String,

    val isPassive: Boolean = false
)

fun CreateCostCenterRequest.convertToEntity(): CostCenterEntity {
    return CostCenterEntity(
        id = null,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive
    )
}
