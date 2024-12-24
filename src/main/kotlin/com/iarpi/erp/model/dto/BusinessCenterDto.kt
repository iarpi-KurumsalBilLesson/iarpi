package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.BusinessCenterEntity

data class BusinessCenterDto(
    var id:Long?,
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean,
)

fun BusinessCenterDto.convertToEntity():BusinessCenterEntity{
    return BusinessCenterEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun BusinessCenterDto.convertToEntity(BusinessCode:String):BusinessCenterEntity{
    return BusinessCenterEntity(
        null,
        BusinessCode,
        this.docTypeText,
        this.isPassive,
    )
}