package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.LanguageEntity
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPMATTEXT")
data class MaterialTextEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_text_sequence")
    @SequenceGenerator(name = "material_text_sequence", sequenceName = "bsmgrirpmattext_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "MATS_TEXT", nullable = false, length = 50)
    val shortText: String,

    @Column(name = "MATL_TEXT", nullable = false, length = 250)
    val longText: String,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAN_ID", nullable = false)
    val language: LanguageEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MATERIAL_HEAD_ID", nullable = false)
    val materialHead: MaterialHeadEntity
)
