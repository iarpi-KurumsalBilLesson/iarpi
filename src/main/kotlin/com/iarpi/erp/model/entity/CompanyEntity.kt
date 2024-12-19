package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.CompanyDto
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "BSMGRIRPGEN001")
data class CompanyEntity(

    //todo: burada adresi de eklememiz lazım, burada gecici olarak adresi kaldirdik

    @Id
    val id: Long?,
    @Column(name = "COM_CODE", nullable = false)
    val comCode: String,
    @Column(name = "COM_TEXT", nullable = false)
    var comText: String
) {
    constructor(comCode: String, comText: String) : this(null, comCode, comText) {
    }
}

fun CompanyEntity.convertToDto(): CompanyDto {
    return CompanyDto(
        id = this.id,
        comCode = this.comCode,
        comText = this.comText,
    )
}
