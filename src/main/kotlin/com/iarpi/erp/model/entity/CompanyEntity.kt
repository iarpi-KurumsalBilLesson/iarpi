package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.control.CompanyDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN001")
data class CompanyEntity(

    //todo: burada adresi de eklememiz lazım, burada gecici olarak adresi kaldirdik

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_sequence")
    @SequenceGenerator(name = "company_sequence", sequenceName = "bsmgrirpgen001_id_seq", allocationSize = 1)
    val id: Long?,
    @Column(name = "COM_CODE", nullable = false)
    val comCode: String,
    @Column(name = "COM_TEXT", nullable = false)
    var comText: String,

    @OneToOne(mappedBy = "companyEntity")
    @JoinColumn(referencedColumnName = "ID")
    var addressEntity: AddressEntity?
) {
    constructor(comCode: String, comText: String) : this(null, comCode, comText,null) {
    }
}

fun CompanyEntity.convertToDto(): CompanyDto {
    return CompanyDto(
        id = this.id,
        comCode = this.comCode,
        comText = this.comText,
    )
}
