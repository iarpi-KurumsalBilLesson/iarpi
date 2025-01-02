package com.iarpi.erp.controller.request

import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.MaterialTextEntity
import com.iarpi.erp.model.entity.control.MaterialEntity
import com.iarpi.erp.model.entity.control.WorkCenterEntity
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import java.math.BigDecimal

data class UpdateMaterialHeadRequest(
    @field:Min(0, message = "Supply type can only be 0 or 1")
    @field:Max(1, message = "Supply type can only be 0 or 1")
    val supplyType: Int,

    val newWeightId: Long,

    val netWeight: BigDecimal?,

    val brutWeightId: Long,

    val brutWeight: BigDecimal,

    val stockUnitId: Long,

    val isBom: Int = 1,

    val isRoute: Int = 1,

    val isDeleted: Boolean = false,

    val isPassive: Boolean = false,

    val shortText: String,

    val longText: String
)

fun UpdateMaterialHeadRequest.applyUpdatesTo(entity: MaterialHeadEntity,materialTextEntity: MaterialTextEntity) = entity.apply {
    entity.supplyType = supplyType
    entity.netWeight = netWeight
    entity.brutWeight = brutWeight
    entity.isBom = isBom
    entity.isRoute = isRoute
    entity.isDeleted = isDeleted
    entity.isPassive = isPassive
    entity.materialText = materialTextEntity
    return entity
}
