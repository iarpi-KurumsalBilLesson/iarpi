package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.CostCenterEntity

data class CostCenterDto(
    var id:Long?,
    var docType:String,
    var docTypeText: String,
    var isPassive:Boolean,
)

fun CostCenterDto.convertToEntity(): CostCenterEntity {
    return CostCenterEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun CostCenterEntity.convertToEntity(CostCenterCode:String): CostCenterEntity {
    return CostCenterEntity(
        null,
        CostCenterCode,
        this.docText,
        this.isPassive,
    )
}
