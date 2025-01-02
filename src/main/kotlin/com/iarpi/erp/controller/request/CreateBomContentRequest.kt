package com.iarpi.erp.controller.request

import com.iarpi.erp.model.entity.BomContentEntity
import com.iarpi.erp.model.entity.BomHeadEntity
import com.iarpi.erp.model.entity.CostCenterHeadEntity
import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import java.math.BigDecimal

data class CreateBomContentRequest(
    @field:jakarta.validation.constraints.NotNull(message = "Şirket ID boş olamaz")
    val companyId: Long,
    @field:jakarta.validation.constraints.NotNull(message = "BOM Başlık ID boş olamaz")
    val bomHeadId: Long,
    @field:jakarta.validation.constraints.NotNull(message = "Maliyet Merkezi ID boş olamaz")
    val costCenterId: Long,
    @field:jakarta.validation.constraints.Positive(message = "İçerik Numarası 0'dan büyük olmalıdır")
    val contentNum: Int,
    @field:jakarta.validation.constraints.NotBlank(message = "Komponent adı boş olamaz")
    @field:jakarta.validation.constraints.Size(max = 255, message = "Komponent adı 255 karakterden uzun olamaz")
    val component: String, //Component name
    @field:jakarta.validation.constraints.DecimalMin(
        value = "0.0",
        inclusive = false,
        message = "Miktar 0'dan büyük olmalıdır"
    )
    val quantity: BigDecimal,
    @field:jakarta.validation.constraints.NotNull(message = "Malzeme Başlık ID boş olamaz")
    val materialHeadId: Long,
    @field:jakarta.validation.constraints.NotNull(message = "Komponent BOM Tür ID boş olamaz")
    val compBomTypeId: Long,
)

fun CreateBomContentRequest.convertToEntity(
    company: CompanyEntity,
    costCenter: CostCenterHeadEntity,
    materialHead: MaterialHeadEntity,
    bomhead: BomHeadEntity,
    compBomType: BomEntity
): BomContentEntity {
    return BomContentEntity(
        id = null,
        contentNum = this.contentNum,
        compBomDocNum = "bu_degeri_anlamadım_bak",
        component = this.component,
        quantity = this.quantity,
        costCenter = costCenter,
        materialHead = materialHead,
        bomHead = bomhead,
        compBomType = compBomType,
        company = company,
    )
}

