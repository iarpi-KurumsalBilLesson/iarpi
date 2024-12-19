package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.CountryDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN003")
data class CountryEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,

    @Column(name = "COUNTRY_CODE", nullable = false)
    var countryCode: String,

    @Column(name = "COUNTRY_TEXT", nullable = false)
    var countryText: String
)

fun CountryEntity.convertToDto(): CountryDto {
    return CountryDto(
        this.id,
        this.countryCode,
        this.countryText,
    )
}
