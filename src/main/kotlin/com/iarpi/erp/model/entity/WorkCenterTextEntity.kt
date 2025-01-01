package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.LanguageEntity
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPWCMTEXT")
data class WorkCenterTextEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_text_sequence")
    @SequenceGenerator(name = "work_center_text_sequence", sequenceName = "bsmgrirpwcmtext_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "WCMS_TEXT", nullable = false, length = 50)
    val wcmsText: String,

    @Column(name = "WCML_TEXT", nullable = false, length = 250)
    val wcmlText: String,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LAN_ID", nullable = false)
    val language: LanguageEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WCM_HEAD_ID", nullable = false)
    val workCenterHead: WorkCenterHeadEntity
)
