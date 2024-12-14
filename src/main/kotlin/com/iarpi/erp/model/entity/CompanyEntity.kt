package com.iarpi.erp.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "BSMGRIRPGEN001")
data class CompanyEntity(

    @Id
    @Column(name = "COM_CODE", nullable = false)
    val comCode: String,
    @Column(name = "COM_TEXT", nullable = false)
    val comText: String
)
