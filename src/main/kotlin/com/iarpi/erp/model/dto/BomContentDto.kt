package com.iarpi.erp.model.dto

import java.math.BigDecimal

data class BomContentDto(
    val id: Long?,
    val companyId: Long,
    val companyName: String,
    val contentNum: Int,
    val component: String,
    val quantity: BigDecimal,
    val costCenterId: Long?,
    val costCenterName: String?,
    val materialHeadId: Long?,
    val materialHeadName: String?,
    val bomHeadId: Long?,
    val bomHeadName: String?,
    val compBomTypeId: Long?,
    val componentBomTypeName: String, //ilgili urun agacının numarası :D

)
