package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.MaterialControlDto
import jakarta.persistence.*


@Entity
@Table(name = "BSMGRIRPMAT001")
data class MaterialEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_sequence")
    @SequenceGenerator(name = "material_sequence", sequenceName = "bsmgrirpmat001_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_TYPE")
    var docType: String,

    @Column(name = "DOC_TYPE_TEXT")
    var docText: String,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean,
)

fun MaterialEntity.convertToDto(): MaterialControlDto {
    return MaterialControlDto(
        this.id,
        this.docType,
        this.docText,
        this.isPassive,
    )
}