package com.iarpi.erp.model.dto.control

data class BomDto(
    val id:Long?,
    var docType:String,
    var docTypeText:String,
    var isPassive:Boolean,
)
