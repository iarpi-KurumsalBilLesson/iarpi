package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class RotBomContentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_bom_content_sequence")
    @SequenceGenerator(name = "rot_bom_content_sequence", sequenceName = "rot_bom_content_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "ROT_DOC_TYPE", nullable = false)
    val rotDocType: Int,

    @Column(name = "COM_DOC_TYPE", nullable = false)
    val comDocType: Int,

    @Column(name = "BOM_DOC_TYPE", nullable = false)
    val bomDocType: Int,

    @Column(name = "MAT_DOC_TYPE", nullable = false)
    val matDocType: Int,

    @Column(name = "OPR_NUM", nullable = false, unique = true)
    val oprNum: Int,

    @Column(name = "CONTENT_NUM", nullable = false, unique = true)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false, length = 25)
    val component: String,

    @Column(name = "QUANTITY", nullable = false, precision = 5, scale = 2)
    val quantity: BigDecimal,

    @Column(name = "ROT_DOC_TYPE", nullable = false, precision = 5, scale = 2)
    val rotDocTypeEntity: BigDecimal,

    @Column(name = "COM_DOC_TYPE", nullable = false, precision = 5, scale = 2)
    val comDocTypeEntity: BigDecimal,

    @Column(name = "BOM_DOC_TYPE", nullable = false, precision = 5, scale = 2)
    val bomDocTypeEntity: BigDecimal,

    @Column(name = "MAT_DOC_TYPE", nullable = false, precision = 5, scale = 2)
    val matDocTypeEntity: BigDecimal,

)
