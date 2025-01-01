package com.iarpi.erp.model.dto.control

data class RouteDto(
    val id: Long?,
    val docType: String,
    val docText: String,
    val isPassive: Boolean,
    val companyId: Long?
)