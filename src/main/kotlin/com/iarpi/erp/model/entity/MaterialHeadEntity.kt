package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPMATHEAD")
data class MaterialHeadEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_head_sequence")
    @SequenceGenerator(name = "material_head_sequence", sequenceName = "bsmgrirpmathead_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "MAT_DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    val matDocFrom: LocalDate,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    val matDocUntil: LocalDate,

    @Column(name = "SUPPLY_TYPE", nullable = false)
    val supplyType: Int,

    @Column(name = "NET_WEIGHT")
    val netWeight: BigDecimal?,

    @Column(name = "BRUT_WEIGHT")
    val brutWeight: BigDecimal?,

    @Column(name = "IS_BOM")
    val isBom: Boolean?,

    @Column(name = "IS_ROUTE")
    val isRoute: Boolean?,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?
)
