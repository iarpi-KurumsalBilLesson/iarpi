package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class BomContentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_content_sequence")
    @SequenceGenerator(name = "bom_content_sequence", sequenceName = "bom_content_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "BOM_DOC_TYPE", nullable = false)
    val bomDocType: Int,

    @Column(name = "MATERIAL_DOC_TYPE", nullable = false)
    val materialDocType: Int,

    @Column(name = "COM_ID", nullable = false)
    val companyId: Int,

    @Column(name = "CONTENT_NUM", nullable = false, unique = true)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false)
    val component: String,

    @Column(name = "COMP_BOM_DOC_TYPE", nullable = false)
    val compBomDocType: String,

    @Column(name = "COMP_BOM_DOC_NUM", nullable = false)
    val compBomDocNum: String,

    @Column(name = "QUANTITY", nullable = false)
    val quantity: BigDecimal
)
