package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table
data class MaterialHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_head_sequence")
    @SequenceGenerator(name = "material_head_sequence", sequenceName = "material_head_id_seq", allocationSize = 1)
    val id : Long,
    @Column(name = "COM_ID", nullable = false)
    val companyId: Int,

    @Column(name = "DOC_TYPE", nullable = false)
    val docType: Int,

    @Column(name = "BOM", nullable = false)
    val bom: Int,

    @Column(name = "ROUTE", nullable = false)
    val route: Int,


    @Column(name = "DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    val matDocFrom: Date,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    val matDocUntil: Date,

    @Column(name = "SUPPLY_TYPE", nullable = false)
    val supplyType: Boolean,

    @Column(name = "ST_UNIT", nullable = false)
    val stockUnit: String,

    @Column(name = "NET_WEIGHT")
    val netWeight: BigDecimal?,

    @Column(name = "NW_UNIT")
    val netWeightUnit: String?,

    @Column(name = "BRUT_WEIGHT")
    val brutWeight: BigDecimal?,

    @Column(name = "BW_UNIT")
    val brutWeightUnit: String?,

    @Column(name = "IS_BOM")
    val isBom: Boolean?,


    @Column(name = "IS_ROUTE")
    val isRoute: Boolean?,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?
)
