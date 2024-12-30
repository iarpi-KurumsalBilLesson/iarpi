package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.BomDto
import jakarta.persistence.*


@Entity
@Table(name = "BSMGRIRPBOM001")
data class BomEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bom_sequence")
    @SequenceGenerator(name = "bom_sequence", sequenceName = "bsmgrirpbom001_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_TYPE")
    var docType: String,

    @Column(name = "DOC_TYPE_TEXT")
    var docText: String,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean,
)

fun BomEntity.convertToDto(): BomDto {
    return BomDto(
        this.id,
        this.docType,
        this.docText,
        this.isPassive,
    )
}


