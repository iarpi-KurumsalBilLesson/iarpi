package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.control.MaterialEntity

data class MaterialControlDto(
    var id: Long?,
    var docType: String,
    var docTypeText: String,
    var isPassive: Boolean
)

fun MaterialControlDto.convertToEntity(): MaterialEntity {
    return MaterialEntity(
        null,
        this.docType,
        this.docTypeText,
        this.isPassive,
    )
}

fun MaterialControlDto.convertToEntity(materialCode: String): MaterialEntity {
    return MaterialEntity(
        null,
        materialCode,
        this.docTypeText,
        this.isPassive,
    )
}