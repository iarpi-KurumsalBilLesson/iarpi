package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.BomHeadEntity
import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.MaterialEntity
import java.math.BigDecimal
import java.time.LocalDate

data class CreateBomHeadRequest(
    val companyId: Long, // column: COMPANY_ID, not nullable
    @field:jakarta.validation.constraints.NotBlank(message = "BOM Belge Numarası boş olamaz")
    @field:jakarta.validation.constraints.Size(max = 20, message = "BOM Belge Numarası 20 karakterden uzun olamaz")
    val bomDocNumber: String, // column: BOM_DOC_NUMBER, VARCHAR(20), not nullable
    @field:jakarta.validation.constraints.NotNull(message = "BOM başlangıç tarihi boş olamaz")
    val bomDocFrom: LocalDate, // column: BOM_DOC_FROM, DATE, not nullable
    @field:jakarta.validation.constraints.NotNull(message = "BOM bitiş tarihi boş olamaz")
    val bomDocUntil: LocalDate, // column: BOM_DOC_UNTIL, DATE, not nullable
    @field:jakarta.validation.constraints.DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Miktar 0'dan büyük olmalıdır"
    )
    val quantity: BigDecimal, // column: QUANTITY, DECIMAL(10,2), not nullable
    @field:jakarta.validation.constraints.Size(max = 50, message = "Çizim Numarası 50 karakterden uzun olamaz")
    val drawNum: String, // column: DRAW_NUM, VARCHAR(50), nullable
    @field:jakarta.validation.constraints.NotNull(message = "Malzeme Başlık ID'si boş olamaz")
    val materialHeadId: Long, // column: MATERIAL_HEAD_ID, not nullable
    @field:jakarta.validation.constraints.NotNull(message = "Malzeme Türü ID'si boş olamaz")
    val materialTypeId: Long, // column: MATERIAL_TYPE_ID, not nullable
    @field:jakarta.validation.constraints.NotNull(message = "BOM Tür ID'si boş olamaz")
    val bomTypeId: Long, // column: BOM_TYPE_ID, not nullable
)

fun CreateBomHeadRequest.convertToEntity(
    companyEntity: CompanyEntity,
    materialHeadEntity: MaterialHeadEntity,
    materialTypeEntity: MaterialEntity,
    bomTypeEntity: BomEntity
): BomHeadEntity {
    return BomHeadEntity(
        id = null,
        docNum = this.bomDocNumber,
        bomDocFrom = bomDocFrom,
        bomDocUntil = this.bomDocUntil,
        quantity = this.quantity,
        isDeleted = false,
        isPassive = false,
        drawNum = this.drawNum,
        company = companyEntity,
        materialType = materialTypeEntity,
        materialHead = materialHeadEntity,
        bomType = bomTypeEntity,
    )
}