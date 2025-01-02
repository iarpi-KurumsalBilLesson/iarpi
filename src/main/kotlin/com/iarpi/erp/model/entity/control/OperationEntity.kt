package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.OperationDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPROT003")
data class OperationEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_sequence")
    @SequenceGenerator(name = "operation_sequence", sequenceName = "bsmgrirprot003_id_seq", allocationSize = 1)
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

fun OperationEntity.convertToDto(): OperationDto {
    return OperationDto(
        id = this.id,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive,
        companyId = this.company.id
    )
}
