package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table
data class WorkCenterTextEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_text_sequence")
    @SequenceGenerator(name = "work_center_text_sequence", sequenceName = "work_center_text_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val comId: Int,

    @Column(name = "LAN_CODE", nullable = false)
    val lanCode: Int,

    @Column(name = "WCM_DOC_TYPE", nullable = false)
    val wcmDocType: Int,

    @Column(name = "WCMS_TEXT", nullable = false, length = 50)
    val wcmsText: String,

    @Column(name = "WCML_TEXT", nullable = false, length = 250)
    val wcmlText: String,


)
