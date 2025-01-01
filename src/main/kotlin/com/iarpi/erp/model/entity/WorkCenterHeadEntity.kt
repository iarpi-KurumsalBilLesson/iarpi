package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.util.*

@Entity
@Table(name = "BSMGRIRPWCMHEAD")
data class WorkCenterHeadEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_head_sequence")
    @SequenceGenerator(name = "work_center_head_sequence", sequenceName = "bsmgrirpwcmhead_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "WCM_DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "WCM_DOC_FROM", nullable = false)
    val wcmDocFrom: Date,

    @Column(name = "WCM_DOC_UNTIL", nullable = false)
    val wcmDocUntil: Date,

    @Column(name = "CCM_DOC_TYPE", nullable = false)
    val costCenterDocType: Int,

    @Column(name = "WORK_TIME")
    val workTime: BigDecimal?,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?
)
