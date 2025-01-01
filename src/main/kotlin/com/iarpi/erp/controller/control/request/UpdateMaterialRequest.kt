package com.iarpi.erp.controller.control.request

import com.iarpi.erp.model.entity.control.MaterialEntity
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class UpdateMaterialRequest(
    @field:NotBlank(message = "Doc Text must not be empty")
    @field:Size(max = 80, message = "Doc Text cannot be longer than 80 characters")
    val docText: String,

    val isPassive: Boolean
)

fun UpdateMaterialRequest.applyUpdatesTo(entity: MaterialEntity): MaterialEntity {
    entity.docText = this.docText
    entity.isPassive = this.isPassive
    return entity
}
