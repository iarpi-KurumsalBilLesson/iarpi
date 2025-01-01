package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPCCMHEAD")
data class CostCenterHeadEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_center_head_sequence")
    @SequenceGenerator(name = "cost_center_head_sequence", sequenceName = "bsmgrirpccmhead_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "CCM_DOC_NUM", nullable = false, unique = true)
    val docNum: String,

    @Column(name = "CCM_DOC_FROM", nullable = false)
    val ccmDocFrom: LocalDate,

    @Column(name = "CCM_DOC_UNTIL", nullable = false)
    val ccmDocUntil: LocalDate,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?
)
