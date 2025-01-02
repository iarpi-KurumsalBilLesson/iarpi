package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.CostCenterHeadEntity
import com.iarpi.erp.model.entity.CostCenterTextEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.CostCenterEntity
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.time.LocalDate

data class CreateCostCenterHeadRequest(
    @field:NotNull(value = "Şirket bilgisi boş olmamalı")
    val companyId: Long,

    @field:NotNull(value = "Maliyet Merkezi türü verilmeli")
    val costCenterTypeId: Long,

//    @field:NotNull(value = "Language cannot be null")
//    val languageId: Long, // material kontrol tablosu

    @field:NotBlank(message = "Maliyet Merkezi numarası girilmeli")
    val ccmDocNumber: String,

    @field:NotBlank(message = "Geçerlilik başlangıç süresi verilmeli")
    val ccmDocFrom: LocalDate,

    @field:NotBlank(message = "Geçerlilik bitiş süresi verilmeli")
    val ccmDocUntil: LocalDate,

    val baseCostCenterId: Long?,

    @field:NotBlank(message = "Maliyet Merkezi kısa açıklaması girilmeli")
    var shortText: String,

    @field:NotBlank(message = "Maliyet Merkezi kısa açıklaması girilmeli")
    var longText: String,
)

fun CreateCostCenterHeadRequest.convertToEntity(
    company: CompanyEntity,
    costCenterType: CostCenterEntity): CostCenterHeadEntity {

    val costCenterHead =  CostCenterHeadEntity(
        null,
        company = company,
        docNum = this.ccmDocNumber,
        ccmDocFrom = this.ccmDocFrom,
        ccmDocUntil = this.ccmDocUntil,
        isDeleted = false,
        isPassive = false,
        costCenterType = costCenterType,
        costCenterText = null,
        baseCostCenter = null
    )

    val costCenterText =  CostCenterTextEntity (
        id = null,
        company = company,
        ccmlText = this.longText,
        ccmsText = this.shortText,
        costCenterHead = costCenterHead
    )

    costCenterHead.costCenterText = costCenterText

    return costCenterHead
}

fun CreateCostCenterHeadRequest.convertToEntity(
    company: CompanyEntity,
    costCenterType: CostCenterEntity,
    costCenterText: CostCenterTextEntity,
    baseCostCenter: CostCenterHeadEntity
): CostCenterHeadEntity {
    return CostCenterHeadEntity(
        null,
        company = company,
        docNum = this.ccmDocNumber,
        ccmDocFrom = this.ccmDocFrom,
        ccmDocUntil = this.ccmDocUntil,
        isDeleted = false,
        isPassive = false,
        costCenterType = costCenterType,
        costCenterText = costCenterText,
        baseCostCenter = baseCostCenter
    )
}
