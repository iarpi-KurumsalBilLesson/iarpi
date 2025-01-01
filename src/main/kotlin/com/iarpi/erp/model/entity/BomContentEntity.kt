package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BSMGRIRPBOMCONTENT")
data class BomContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_content_sequence")
    @SequenceGenerator(name = "bom_content_sequence", sequenceName = "bsmgrirpbomcontent_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "CONTENT_NUM", nullable = false, unique = true)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false)
    val component: String,

    @Column(name = "COMP_BOM_DOC_NUM", nullable = false)
    val compBomDocNum: String,

    @Column(name = "QUANTITY", nullable = false)
    val quantity: BigDecimal
)
