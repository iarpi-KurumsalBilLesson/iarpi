package com.iarpi.erp.model.dto.control

data class CostCenterDto(
    val id: Long?,
    val docType: String,
    val docText: String,
    val isPassive: Boolean
)
