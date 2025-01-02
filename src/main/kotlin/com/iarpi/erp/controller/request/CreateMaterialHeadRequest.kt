package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.MaterialTextEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.MaterialEntity
import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreateMaterialHeadRequest(

    @field:NotNull(value = "Şirket bilgisi boş olamaz")
    val companyId: Long,

    @field:NotNull(value = "Malzeme bilgisi boş olamaz")
    val materialId: Long,

//    @field:NotNull(value = "Dil ID'si boş olamaz")
//    val languageId: Long, // material kontrol tablosu

    @field:NotBlank(message = "Belge numarası boş olamaz")
    val matDocNumber: String,

    @field:NotNull(value = "Geçerlilik başlangıç tarihi boş olamaz")
    val matDocFrom: LocalDate,

    @field:NotNull(value = "Geçerlilik bitiş tarihi boş olamaz")
    val matDocUntil: LocalDate,

    @field:Min(0, message = "Tedarik tipi yalnızca 0 ya da 1 olabilir")
    @field:Max(1, message = "Tedarik tipi yalnızca 0 ya da 1 olabilir")
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

    @field:NotBlank(message = "Kısa açıklama boş olamaz")
    var shortText: String,

    @field:NotBlank(message = "Uzun açıklama boş olamaz")
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
