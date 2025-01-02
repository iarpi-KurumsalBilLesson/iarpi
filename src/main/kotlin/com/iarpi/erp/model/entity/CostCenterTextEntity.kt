package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.LanguageEntity
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPCCMTEXT")
data class CostCenterTextEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_center_text_sequence")
    @SequenceGenerator(name = "cost_center_text_sequence", sequenceName = "bsmgrirpccmtext_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "CCMS_TEXT", nullable = false, length = 50)
    var ccmsText: String,

    @Column(name = "CCML_TEXT", nullable = false, length = 250)
    var ccmlText: String,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCM_HEAD_ID", nullable = false)
    val costCenterHead: CostCenterHeadEntity
)
