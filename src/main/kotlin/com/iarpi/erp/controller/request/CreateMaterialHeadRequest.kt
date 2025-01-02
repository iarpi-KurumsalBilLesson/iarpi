package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.MaterialTextEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.LanguageEntity
import com.iarpi.erp.model.entity.control.MaterialEntity
import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreateMaterialHeadRequest(

    @field:NotNull(value = "Company cannot be null")
    val companyId: Long,

    @field:NotNull(value = "Material cannot be null")
    val materialId: Long,

//    @field:NotNull(value = "Language cannot be null")
//    val languageId: Long, // material kontrol tablosu

    @field:NotBlank(message = "Document number cannot be blank")
    val matDocNumber: String,

    @field:NotBlank(message = "Document date cannot be blank")
    val matDocFrom: LocalDate,

    @field:NotBlank(message = "Document date cannot be blank")
    val matDocUntil: LocalDate,

    @field:Min(0, message = "Supply type can only be 0 or 1")
    @field:Max(1, message = "Supply type can only be 0 or 1")
    val supplyType: Int,

    val newWeightId: Long,

    val netWeight: BigDecimal?,

    val brutWeightId: Long,

    val brutWeight: BigDecimal,

    val stockUnitId: Long,

    val isBom: Int = 1,

    val isRoute: Int = 1,

    val isDeleted: Boolean = false,

    val isPassive: Boolean = false,

    @field:NotBlank(message = "ShortText date cannot be blank")
    var shortText: String,

    @field:NotBlank(message = "LongText date cannot be blank")
    var longText: String,
)

fun CreateMaterialHeadRequest.convertToEntity(
    company: CompanyEntity,
    material: MaterialEntity,
    stockUnit: UnitEntity,
    netWeightUnit: UnitEntity,
    brutWeightUnit: UnitEntity,
): MaterialHeadEntity {

    val materialHead = MaterialHeadEntity(
        null,
        docNum = this.matDocNumber,
        matDocFrom = this.matDocFrom,
        matDocUntil = this.matDocUntil,
        supplyType = this.supplyType,
        netWeight = this.netWeight,
        brutWeight = this.brutWeight,
        isBom = this.isBom,
        isDeleted = this.isDeleted,
        isPassive = this.isPassive,
        isRoute = this.isRoute,
        company = company,
        materialType = material,
        materialText = null,
        netWeightUnit = netWeightUnit,
        brutWeightUnit = brutWeightUnit,
        stockUnit = stockUnit
    )

    val materialText = MaterialTextEntity(
        id = null,
        company = company,
        shortText = this.shortText,
        longText = this.longText,
        materialHead = materialHead
    )

    materialHead.materialText = materialText

    return materialHead
}
