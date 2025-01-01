package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BSMGRIRPROTOPRCONTENT")
data class RotOprContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_opr_content_sequence")
    @SequenceGenerator(
        name = "rot_opr_content_sequence",
        sequenceName = "bsmgrirprotoprcontent_id_seq",
        allocationSize = 1
    )
    val id: Long,

    @Column(name = "OPR_NUM", nullable = false, unique = true)
    val operationNum: Int,

    @Column(name = "OPR_CODE", nullable = false)
    val operationCode: String,

    @Column(name = "SETUP_TIME", nullable = false)
    val setupTime: BigDecimal?,

    @Column(name = "MACHINE_TIME")
    val machineTime: BigDecimal?,

    @Column(name = "LABOUR_TIME")
    val labourTime: BigDecimal?
)
