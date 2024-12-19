package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.CityDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN004")
data class CityEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    @Column(name = "CITY_CODE")
    var cityCode: String,

    @Column(name = "CITY_TEXT")
    var cityText: String,

    @JoinColumn(name = "COUNTRY_ID")
    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    var country: CountryEntity?
)

fun CityEntity.convertToDto(): CityDto {
    return CityDto(
        this.id,
        this.country?.countryCode,
        this.cityCode,
        this.cityText
    )
}
