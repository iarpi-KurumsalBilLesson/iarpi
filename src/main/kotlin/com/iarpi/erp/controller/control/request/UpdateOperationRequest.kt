package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.OperationEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateOperationRequest(
    @field:NotBlank(message = "Doc Text must not be empty")
    @field:Size(max = 80, message = "Doc Text cannot be longer than 80 characters")
    val docText: String,

    val isPassive: Boolean
)

fun UpdateOperationRequest.applyUpdatesTo(entity: OperationEntity): OperationEntity {
    entity.docText = this.docText
    entity.isPassive = this.isPassive
    return entity
}
