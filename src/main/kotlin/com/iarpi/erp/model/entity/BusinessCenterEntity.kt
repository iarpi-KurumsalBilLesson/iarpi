package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.BomDto
import com.iarpi.erp.model.dto.BusinessCenterDto
import com.iarpi.erp.model.dto.CostCenterDto
import com.iarpi.erp.model.dto.RouteDto
import jakarta.persistence.*


@Entity
@Table(name = "BSMGRIRPROT002")
data class BusinessCenterEntity(

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

fun BusinessCenterEntity.convertToDto(): BusinessCenterDto {
    return BusinessCenterDto(
        this.id,
        this.docType,
        this.docText,
        this.isPassive,
    )
}



