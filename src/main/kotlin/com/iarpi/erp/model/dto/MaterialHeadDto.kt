package com.iarpi.erp.model.dto

import java.time.LocalDate

data class MaterialHeadDto(
    val id: Long,
    val docNumber: String,
    val matDocFrom: LocalDate,
    val matDocUntil: LocalDate,
    val supplyType: Int,
    val netWeight: Float?,
    val brutWeight: Float?,
    val isBom: Int?,
    val bomDocNumber: String?,
    val isRoute: Int?,
    val rotDocNum: String?,
    val isDeleted: Boolean?,
    val isPassive: Boolean?,
    val stUnitId: Long,
    val companyId: Long,
    val materialId: Long,
    val nwUnitId: Long,
    val bwUnitId: Long,
    val bomDocTypeId: Long,
    val rotDocTypeId: Long,
)

/*fun MaterialHeadDto.convertToMaterialHeadEntity(): MaterialHeadEntity {

    return MaterialHeadEntity(
        null,
        this.docNumber,
        this.matDocFrom,
        this.matDocUntil,
        this.supplyType,
        this.netWeight,
        this.brutWeight,
        this.isBom,
        this.bomDocNumber,
        this.isRoute,
        this.rotDocNum,
        this.isDeleted,
        this.isPassive,
        null,
        null,
        null,
        null,
        null,
        null,
        null,

        )
}*/
