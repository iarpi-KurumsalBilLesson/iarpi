package com.iarpi.erp.model.entity

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
    val id: Long,

    @Column(name = "MAT_DOC_NUM", nullable = false, unique = true, length = 25)
    val docNum: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    val matDocFrom: LocalDate,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    val matDocUntil: LocalDate,

    @Column(name = "SUPPLY_TYPE", nullable = false)
    val supplyType: Int,

    @Column(name = "NET_WEIGHT", precision = 12, scale = 3)
    val netWeight: BigDecimal?,

    @Column(name = "BRUT_WEIGHT", precision = 12, scale = 3)
    val brutWeight: BigDecimal?,

    @Column(name = "IS_BOM")
    val isBom: Int?,

    @Column(name = "IS_ROUTE")
    val isRoute: Int?,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?,

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
    val materialText: MaterialTextEntity?
)
