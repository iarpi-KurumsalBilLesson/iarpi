package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table
data class WorkCenterOprEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_opr_sequence")
    @SequenceGenerator(name = "work_center_opr_sequence", sequenceName = "work_center_opr_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val comId: Int,

    @Column(name = "WCM_DOC_TYPE", nullable = false)
    val wcmDocType: Int,

    @Column(name = "DOC_TYPE", nullable = false, unique = true, length = 4)
    val docType: String,


)
