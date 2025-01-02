package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.WorkCenterDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPWCM001")
data class WorkCenterEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "workCenter_sequence")
    @SequenceGenerator(name = "workCenter_sequence", sequenceName = "bsmgrirpwcm001_id_seq", allocationSize = 1)
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

fun WorkCenterEntity.convertToDto(): WorkCenterDto {
    return WorkCenterDto(
        id = this.id,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive,
        companyId = this.company.id
    )
}

