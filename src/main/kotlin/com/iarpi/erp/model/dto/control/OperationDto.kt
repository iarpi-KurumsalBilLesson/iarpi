package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.control.OperationEntity

data class OperationDto(
    val id: Long?,
    val docType: String,
    val docText: String,
    val isPassive: Boolean,
    val companyId: Long?
)

fun OperationDto.convertToEntity(): OperationEntity {
    return OperationEntity(
        null,
        this.docType,
        this.docText,
        this.isPassive,
    )
}

fun OperationDto.convertToEntity(OperationCode:String): OperationEntity {
    return OperationEntity(
        null,
        OperationCode,
        this.docText,
        this.isPassive,
    )
}
