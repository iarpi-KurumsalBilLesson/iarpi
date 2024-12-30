package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table
data class CostCenterHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_center_head_sequence")
    @SequenceGenerator(name = "cost_center_head_sequence", sequenceName = "cost_center_head_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "COM_ID", nullable = false)
    val companyId: Int,

    @Column(name = "DOC_TYPE", nullable = false)
    val docType: Int,


    @Column(name = "DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "CCM_DOC_FROM", nullable = false)
    val ccmDocFrom: Date,

    @Column(name = "CCM_DOC_UNTIL", nullable = false)
    val ccmDocUntil: Date,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?
)
