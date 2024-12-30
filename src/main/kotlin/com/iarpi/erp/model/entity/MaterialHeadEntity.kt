package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.MaterialHeadDto
import com.iarpi.erp.model.entity.control.*
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "material_head")
data class MaterialHeadEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_sequence")
    @SequenceGenerator(name = "unit_sequence", sequenceName = "bsmgrirpgen005_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_NUMBER", nullable = false)
    var docNumber: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    var matDocFrom: LocalDate,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    var matDocUntil: LocalDate,

    @Column(name = "SUPPLYTYPE", nullable = false)
    var supplyType: Int,

    @Column(name = "NET_WEIGHT")
    var netWeight: Float?, // burada sayi buyuklugu ile alakali problem olabilir

    @Column(name = "BRUT_WEIGHT")
    var brutWeight: Float?, // burada sayi buyuklugu ile alakali problem olabilir

    @Column(name = "IS_BOM")
    var isBom: Int?,

    @Column(name = "BOM_DOC_NUM")
    var bomDocNum: String?,

    @Column(name = "IS_ROUTE")
    var isRoute: Int?,

    @Column(name = "ROT_DOC_NUM")
    var rotDocNum: String?,

    @Column(name = "IS_DELETED")
    var isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ST_UNIT_ID", referencedColumnName = "id", nullable = false)
    var stUnitId: UnitEntity,

    @ManyToOne(fetch = FetchType.LAZY) // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id", nullable = false)
    var company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY) // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "MAT_DOC_TYPE_ID", referencedColumnName = "id", nullable = false)
    var material: MaterialEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NW_UNIT", referencedColumnName = "id", nullable = false)
    var nwUnit: UnitEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BW_UNIT", referencedColumnName = "id", nullable = false)
    var bwUnit: UnitEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM_DOC_TYPE", referencedColumnName = "id", nullable = false)
    var bomDocType: BomEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROT_DOC_TYPE", referencedColumnName = "id", nullable = false)
    var rotDocType: RouteEntity,

    @OneToOne(mappedBy = "materialHead", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "material_text", referencedColumnName = "id", nullable = false)
    var materialText: MaterialTextEntity? = null,
)

fun MaterialHeadEntity.convertToDto(): MaterialHeadDto {
    return MaterialHeadDto(
        this.id ?: -1L,
        this.docNumber,
        this.matDocFrom,
        this.matDocUntil,
        this.supplyType,
        this.netWeight,
        this.brutWeight,
        this.isBom,
        this.bomDocNum,
        this.isRoute,
        this.rotDocNum,
        this.isDeleted,
        this.isPassive,
        this.stUnitId.id ?: -1L,
        this.company.id ?: -1L,
        this.material.id ?: -1L,
        this.nwUnit.id ?: -1L,
        this.bwUnit.id ?: -1L,
        this.bomDocType.id ?: -1L,
        this.rotDocType.id ?: -1L
    )
}