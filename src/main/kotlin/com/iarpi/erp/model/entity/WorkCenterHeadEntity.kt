package com.iarpi.erp.model.entity

import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.WorkCenterEntity
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPWCMHEAD")
data class WorkCenterHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_center_head_sequence")
    @SequenceGenerator(name = "work_center_head_sequence", sequenceName = "bsmgrirpwcmhead_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "WCM_DOC_NUM", nullable = false, unique = true, length = 25)
    val docNum: String,

    @Column(name = "WCM_DOC_FROM", nullable = false)
    val wcmDocFrom: LocalDate = LocalDate.now(),

    @Column(name = "WCM_DOC_UNTIL", nullable = false)
    val wcmDocUntil: LocalDate = LocalDate.now(),

    @Column(name = "WORK_TIME", precision = 3, scale = 2)
    val workTime: BigDecimal?,

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    val isPassive: Boolean?,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASE_WCM_HEAD_ID")
    val baseWorkCenter: WorkCenterHeadEntity?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCM_HEAD_ID")
    val costCenter: CostCenterHeadEntity?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WCM_DOC_TYPE_ID", nullable = false)
    val workCenterType: WorkCenterEntity,

    @OneToMany(mappedBy = "baseWorkCenter", cascade = [CascadeType.ALL])
    val subWorkCenters: MutableList<WorkCenterHeadEntity> = mutableListOf(),

    @OneToOne(mappedBy = "workCenterHead", cascade = [CascadeType.ALL], orphanRemoval = true)
    val workCenterText: WorkCenterTextEntity?
)
