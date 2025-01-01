package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPWCMOPR")
data class WorkCenterOprEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_opr_sequence")
    @SequenceGenerator(name = "work_center_opr_sequence", sequenceName = "bsmgrirpwcmopr_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "OPR_CODE", nullable = false, unique = true, length = 4)
    val oprCode: String,
)
