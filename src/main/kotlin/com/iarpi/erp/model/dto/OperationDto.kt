package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.BusinessCenterEntity
import com.iarpi.erp.model.entity.OperationEntity

data class OperationDto(
    var id:Long?,
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean,
)

fun OperationDto.convertToEntity(): OperationEntity {
    return OperationEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun OperationDto.convertToEntity(OperationCode:String):OperationEntity{
    return OperationEntity(
        null,
        OperationCode,
        this.docTypeText,
        this.isPassive,
    )
}
