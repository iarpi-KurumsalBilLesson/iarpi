package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BSMGRIRPROTOPRCONTENT")
data class RotOprContentEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rot_opr_content_sequence")
    @SequenceGenerator(
        name = "rot_opr_content_sequence",
        sequenceName = "bsmgrirprotoprcontent_id_seq",
        allocationSize = 1
    )
    val id: Long,

    @Column(name = "OPR_NUM", nullable = false, unique = true)
    val operationNum: Int,

    @Column(name = "OPR_CODE", nullable = false)
    val operationCode: String,

    @Column(name = "SETUP_TIME", nullable = false)
    val setupTime: BigDecimal?,

    @Column(name = "MACHINE_TIME")
    val machineTime: BigDecimal?,

    @Column(name = "LABOUR_TIME")
    val labourTime: BigDecimal?,

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val rotBomContentEntity: MutableList<RotBomContentEntity> = mutableListOf(),

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROT_HEAD_ID", nullable = false, referencedColumnName = "id")
    val rotHead: RotHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOM_HEAD_ID", nullable = false, referencedColumnName = "id")
    val bomHead: BomHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCM_HEAD_ID", nullable = false, referencedColumnName = "id")
    val ccmHead: CostCenterHeadEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WCM_HEAD_ID", nullable = false, referencedColumnName = "id")
    val wcmHead: WorkCenterHeadEntity,
)
