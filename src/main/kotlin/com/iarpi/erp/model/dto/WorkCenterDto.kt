package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.WorkCenterEntity

data class WorkCenterDto(
    var id:Long?,
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean,
)

fun WorkCenterDto.convertToEntity():WorkCenterEntity{
    return WorkCenterEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun WorkCenterDto.convertToEntity(BusinessCode:String):WorkCenterEntity{
    return WorkCenterEntity(
        null,
        BusinessCode,
        this.docTypeText,
        this.isPassive,
    )
}