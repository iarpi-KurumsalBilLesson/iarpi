package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.RouteDto
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COM_ID", nullable = false)
    val company: CompanyEntity
)

fun RouteEntity.convertToDto(): RouteDto {
    return RouteDto(
        id = this.id,
        docType = this.docType,
        docText = this.docText,
        isPassive = this.isPassive,
        companyId = this.company.id
    )
}

