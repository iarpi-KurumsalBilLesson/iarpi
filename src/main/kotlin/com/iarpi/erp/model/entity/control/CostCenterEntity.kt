package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.CostCenterDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPCCM001")
data class CostCenterEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costCenter_sequence")
    @SequenceGenerator(name = "costCenter_sequence", sequenceName = "bsmgrirpccm001_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_TYPE")
    var docType: String,

    @Column(name = "DOC_TYPE_TEXT")
    var docText: String,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_CODE_ID", nullable = false)
    val company: CompanyEntity
)

fun CostCenterEntity.convertToDto(): CostCenterDto {
    return CostCenterDto(
        id = this.id,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive
    )
}

