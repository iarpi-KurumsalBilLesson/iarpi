package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table
data class CostCenterTextEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_center_text_sequence")
    @SequenceGenerator(name = "cost_center_text_sequence", sequenceName = "cost_center_text_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val comId: Int,

    @Column(name = "LAN_ID", nullable = false)
    val lanId: Int,

    @Column(name = "CCMS_TEXT", nullable = false, length = 50)
    val ccmsText: String,

    @Column(name = "CCML_TEXT", nullable = false, length = 250)
    val ccmlText: String,

    @Column(name = "CCM_ID", nullable = false)
    val ccmId: Int,

)
