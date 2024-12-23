package com.iarpi.erp.model.dto

import com.iarpi.erp.model.entity.MaterialEntity

data class MaterialDto(
    var id: Long?,
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun MaterialDto.convertToEntity(): MaterialEntity {
    return MaterialEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun MaterialDto.convertToEntity(materialCode: String): MaterialEntity {
    return MaterialEntity(
        null,
        materialCode,
        this.docTypeText,
        this.isPassive,
    )
}