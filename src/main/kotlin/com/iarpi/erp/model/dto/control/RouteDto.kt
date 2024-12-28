package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.RouteEntity

data class RouteDto(
    var id:Long?,
    var docType:String,
    var docTypeText: String,
    var isPassive:Boolean,
)

fun RouteDto.convertToEntity():RouteEntity{
    return RouteEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun RouteDto.convertToEntity(BomCode:String):RouteEntity{
    return RouteEntity(
        null,
        BomCode,
        this.docTypeText,
        this.isPassive,
    )
}