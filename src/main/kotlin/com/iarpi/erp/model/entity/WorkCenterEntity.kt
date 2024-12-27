package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.WorkCenterDto
import jakarta.persistence.*


@Entity
@Table(name = "BSMGRIRPROT002")
data class WorkCenterEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_sequence")
    @SequenceGenerator(name = "business_sequence", sequenceName = "bsmgrirprot002_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_TYPE")
    var docType: String,

    @Column(name = "DOC_TYPE_TEXT")
    var docText: String,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean,
)

fun WorkCenterEntity.convertToDto(): WorkCenterDto {
    return WorkCenterDto(
        this.id,
        this.docType,
        this.docText,
        this.isPassive,
    )
}



