package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class RotBomContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_bom_content_sequence")
    @SequenceGenerator(
        name = "rot_bom_content_sequence",
        sequenceName = "bsmgrirprotbomcontent_id_seq",
        allocationSize = 1
    )
    val id: Long,

    @Column(name = "OPR_NUM", nullable = false, unique = true)
    val oprNum: Int,

    @Column(name = "CONTENT_NUM", nullable = false, unique = true)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false, length = 25)
    val component: String,

    @Column(name = "QUANTITY", nullable = false, precision = 5, scale = 2)
    val quantity: BigDecimal

)
