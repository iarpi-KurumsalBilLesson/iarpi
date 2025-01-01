package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BSMGRIRPBOMCONTENT")
data class BomContentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_content_sequence")
    @SequenceGenerator(name = "bom_content_sequence", sequenceName = "bsmgrirpbomcontent_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "CONTENT_NUM", nullable = false)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false, length = 25)
    val component: String,

    @Column(name = "COMP_BOM_DOC_NUM", nullable = false, length = 25)
    val compBomDocNum: String,

    @Column(name = "QUANTITY", nullable = false, precision = 5)
    val quantity: BigDecimal,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COST_CENTER_ID", nullable = false)
    val costCenter: CostCenterHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAT_HEAD_ID", nullable = false)
    val materialHead: MaterialHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM_HEAD_ID", nullable = false)
    val bomHead: BomHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMP_BOM_DOC_TYPE_ID", nullable = false)
    val compBomType: BomEntity
)
