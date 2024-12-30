package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table
data class BomHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_head_sequence")
    @SequenceGenerator(name = "bom_head_sequence", sequenceName = "bom_head_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val companyId: Int,

    @Column(name = "MATERIAL_DOC_TYPE", nullable = false)
    val materialDocType: Int,

    @Column(name = "BOM_DOC_TYPE", nullable = false)
    val bomDocType: Int,

    @Column(name = "DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "BOM_DOC_FROM", nullable = false)
    val bomDocFrom: Date,

    @Column(name = "BOM_DOC_UNTIL", nullable = false)
    val bomDocUntil: Date,

    @Column(name = "QUANTITY", nullable = false)
    val quantity: BigDecimal,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?,

    @Column(name = "DRAW_NUM")
    val drawNum: String?
)
