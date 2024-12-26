package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.BomDto
import com.iarpi.erp.model.dto.CostCenterDto
import com.iarpi.erp.model.dto.RouteDto
import jakarta.persistence.*


@Entity
@Table(name = "BSMGRIRPROT001")
data class RouteEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_sequence")
    @SequenceGenerator(name = "route_sequence", sequenceName = "bsmgrirprot001_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_TYPE")
    var docType: String,

    @Column(name = "DOC_TYPE_TEXT")
    var docText: String,

    @Column(name = "IS_PASSIVE")
    var isPassive: Boolean,
)

fun RouteEntity.convertToDto(): RouteDto {
    return RouteDto(
        this.id,
        this.docType,
        this.docText,
        this.isPassive,
    )
}



