package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.CostCenterHeadDto
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.CostCenterEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "BSMGRIRPCCMHEAD")
data class CostCenterHeadEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cost_center_head_sequence")
    @SequenceGenerator(name = "cost_center_head_sequence", sequenceName = "bsmgrirpccmhead_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "CCM_DOC_NUM", nullable = false, unique = true, length = 25)
    val docNum: String,

    @Column(name = "CCM_DOC_FROM", nullable = false)
    val ccmDocFrom: LocalDate = LocalDate.now(),

    @Column(name = "CCM_DOC_UNTIL", nullable = false)
    val ccmDocUntil: LocalDate = LocalDate.now(),

    @Column(name = "IS_DELETED")
    val isDeleted: Boolean?,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean?,

    // İlişkiler
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CCM_DOC_TYPE_ID", nullable = false)
    val costCenterType: CostCenterEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BASE_CCM_ID")
    var baseCostCenter: CostCenterHeadEntity?,

    @OneToMany(mappedBy = "baseCostCenter", cascade = [CascadeType.ALL]) //todo: buralar kafamı karıştırdı ?
    val subCostCenters: MutableList<CostCenterHeadEntity> = mutableListOf(),

    @OneToOne(mappedBy = "costCenterHead", cascade = [CascadeType.ALL], orphanRemoval = true)
    var costCenterText: CostCenterTextEntity?
)

fun CostCenterHeadEntity.convertToEntity(): CostCenterHeadDto {
    return CostCenterHeadDto(
        id = this.id,
        docNum = this.docNum,
        ccmDocFrom = this.ccmDocFrom,
        ccmDocUntil = this.ccmDocUntil,
        deletedName = this.isDeleted.toString(),
        passiveName = this.isPassive.toString(),
        companyName = this.company.comCode,
        shortText = this.costCenterText?.ccmsText,
        longText = this.costCenterText?.ccmlText,
        ccmType = this.costCenterType.docType,
        baseCostCenterName = this.baseCostCenter?.docNum
    )
}
