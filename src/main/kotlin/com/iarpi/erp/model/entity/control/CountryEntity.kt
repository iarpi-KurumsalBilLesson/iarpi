package com.iarpi.erp.model.entity.control

import com.iarpi.erp.model.dto.control.CountryDto
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
    var countryText: String,

    @OneToMany(mappedBy = "country", targetEntity = CityEntity::class, fetch = FetchType.EAGER)
    var city: List<CityEntity> = mutableListOf()
)

fun CountryEntity.convertToDto(): CountryDto {
    return CountryDto(
        this.id,
        this.countryCode,
        this.countryText,
    )
}
