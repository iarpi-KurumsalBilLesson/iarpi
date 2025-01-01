package com.iarpi.erp.model.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BSMGRIRPROTBOMCONTENT")
data class RotBomContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_bom_content_sequence")
    @SequenceGenerator(
        name = "rot_bom_content_sequence",
        sequenceName = "bsmgrirprotbomcontent_id_seq",
        allocationSize = 1
    )
    val id: Long,

    @Column(name = "OPR_NUM", nullable = false)
    val oprNum: Int,

    @Column(name = "CONTENT_NUM", nullable = false)
    val contentNum: Int,

    @Column(name = "COMPONENT", nullable = false, length = 25)
    val component: String,

    @Column(name = "QUANTITY", nullable = false, precision = 5, scale = 2)
    val quantity: BigDecimal,

    // İlişkiler

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROT_HEAD_ID", nullable = false)
    val rotHead: RotHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROT_OPR_CONTENT_ID", nullable = false)
    val rotOperationContent: RotOprContentEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCM_HEAD_ID", nullable = false)
    val costCenterHead: CostCenterHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MAT_HEAD_ID", nullable = false)
    val materialHead: MaterialHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM_HEAD_ID", nullable = false)
    val bomHead: BomHeadEntity
)
