package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table
data class RotOprContentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_opr_content_sequence")
    @SequenceGenerator(name = "rot_opr_content_sequence", sequenceName = "rot_opr_content_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val companyId: Int,

    @Column(name = "ROUTE_DOC_TYPE", nullable = false)
    val routeDocType: Int,

    @Column(name = "WORK_DOC_TYPE", nullable = false)
    val workCenterDocType: Int,

    @Column(name = "MAT_DOC_TYPE", nullable = false)
    val materialDocType: Int,


    @Column(name = "OPR_NUM", nullable = false, unique = true)
    val operationNum: Int,

    @Column(name = "OPR_DOC_TYPE", nullable = false)
    val operationDocType: String,

    @Column(name = "SETUP_TIME", nullable = false)
    val setupTime: BigDecimal?,

    @Column(name = "MACHINE_TIME")
    val machineTime: BigDecimal?,

    @Column(name = "LABOUR_TIME")
    val labourTime: BigDecimal?
)
