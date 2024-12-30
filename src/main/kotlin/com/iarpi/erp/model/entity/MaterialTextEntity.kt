package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table
data class MaterialTextEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_text_sequence")
    @SequenceGenerator(name = "material_text_sequence", sequenceName = "material_text_id_seq", allocationSize = 1)
    val id : Long,

    @Column(name = "LAN", nullable = false)
    val language: String,

    @Column(name = "MATS_TEXT", nullable = false)
    val shortText: String,

    @Column(name = "MATL_TEXT", nullable = false)
    val longText: String,

    @Column(name = "MATL_TEXT", nullable = false)
    val materialHead: String,

)
