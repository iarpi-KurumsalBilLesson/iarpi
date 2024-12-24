package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.BomEntity

data class BomDto(
    var id:Long?,
    var docType:String,
    var docTypeText:String,
    var isPassive:Boolean,
)

fun BomDto.convertToEntity(): BomEntity {
    return BomEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun BomDto.convertToEntity(BomCode:String):BomEntity
{
    return BomEntity(
        null,
        BomCode,
        this.docTypeText,
        this.isPassive,
    )
}
