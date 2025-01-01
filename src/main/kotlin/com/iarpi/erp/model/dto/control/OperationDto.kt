package com.iarpi.erp.model.dto.control

import com.iarpi.erp.model.entity.control.OperationEntity

data class OperationDto(
    val id: Long?,
    val docType: String,
    val docText: String,
    val isPassive: Boolean,
    val companyId: Long?
)
