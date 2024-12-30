package com.iarpi.erp.controller.request

data class UpdateMaterialHeadRequest(
    val supplyType: Int,
    val netWeight: Float,
    val brutWeight: Float,
    val isBom: Int,
    val bomDocNumber: String,
    val isRoute: Int,
    val rotDocNum: String,
    val isDeleted: Boolean,
    val isPassive: Boolean,
    val stUnitId: Long,
    val nwUnitId: Long,
    val bwUnitId: Long,
    val bomDocTypeId: Long,
    val rotDocTypeId: Long,
)
