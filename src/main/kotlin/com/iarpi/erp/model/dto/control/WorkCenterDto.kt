package com.iarpi.erp.model.dto.control

data class WorkCenterDto(
    var id: Long?,
    var docType: String,
    var docText: String,
    var isPassive: Boolean,
    val companyId: Long?
)