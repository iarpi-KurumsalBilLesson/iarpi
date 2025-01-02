package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.MaterialHeadDto
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.MaterialEntity
import com.iarpi.erp.model.entity.control.UnitEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPMATHEAD")
data class MaterialHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_head_sequence")
    @SequenceGenerator(name = "material_head_sequence", sequenceName = "bsmgrirpmathead_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "MAT_DOC_NUM", nullable = false, unique = true, length = 25)
    val docNum: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    val matDocFrom: LocalDate,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    val matDocUntil: LocalDate,

    @Column(name = "SUPPLY_TYPE", nullable = false)
    var supplyType: Int,

    @Column(name = "NET_WEIGHT", precision = 12, scale = 3)
    var netWeight: BigDecimal?,

    @Column(name = "BRUT_WEIGHT", precision = 12, scale = 3)
    var brutWeight: BigDecimal?,

    @Column(name = "IS_BOM")
    var isBom: Int?,

    @Column(name = "IS_ROUTE")
    var isRoute: Int?,

    @Column(name = "IS_DELETED")
    var isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean?,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAT_DOC_TYPE_ID", nullable = false)
    val materialType: MaterialEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ST_UNIT_ID", nullable = false)
    val stockUnit: UnitEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NW_UNIT_ID")
    val netWeightUnit: UnitEntity?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BW_UNIT_ID")
    val brutWeightUnit: UnitEntity?,

    @OneToOne(mappedBy = "materialHead", cascade = [CascadeType.ALL], orphanRemoval = true)
    var materialText: MaterialTextEntity?
)

fun MaterialHeadEntity.convertToDto() : MaterialHeadDto {
    var supplyTypeName: String? = null
    var isBomName: String? = null
    var isRouteName: String? = null

    if (this.supplyType == 0){
        supplyTypeName = "Satın Alınan"
    }else {
        supplyTypeName = "Uretilen"
    }

    if (this.isBom == 0){
        isBomName = "Hayır"
    }else if (this.isBom == 1){
        isBomName = "Evet"
    }else{
        isBomName = "Olmayacak"

    }

    if (this.isRoute == 0){
        isRouteName = "Hayır"
    }else if (this.isBom == 1){
        isRouteName = "Evet"
    }else{
        isRouteName = "Olmayacak"

    }

    return MaterialHeadDto(
        id = this.id!!,
        docNum = this.docNum,
        matDocFrom = this.matDocFrom,
        matDocUntil = this.matDocUntil,
        supplyTypeName = supplyTypeName,
        netWeight = this.netWeight,
        brutWeight = this.brutWeight,
        bomName = isBomName,
        routeName = isRouteName,
        deletedName = this.isDeleted.toString(),
        passiveName = this.isPassive.toString(),
        companyName = this.company.comCode,
        materialTypeName = this.materialType.docType,
        stockUnitName = this.stockUnit.unitCode,
        netWeightUnitName = this.netWeightUnit?.unitCode,
        brutWeightUnitName = this.brutWeightUnit?.unitCode,
        shortText = this.materialText?.shortText,
        longText = this.materialText?.longText,
    )
}
