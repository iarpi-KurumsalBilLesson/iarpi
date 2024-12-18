package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.CountryDto
import jakarta.persistence.*
import lombok.Setter
import java.io.Serializable

@Entity
@Table(name = "BSMGRIRPGEN003")
data class CountryEntity(

    @EmbeddedId
    val id: CountryId,

    @Column(name = "COUNTRY_TEXT", nullable = false)
    var countryText: String,

    @MapsId("comCode")
    @ManyToOne
    @JoinColumn(name = "COM_CODE")
    val comCode: CompanyEntity?
) {
    constructor(countryText: String, id: CountryId) : this(
        countryText = countryText,
        id = id,
        comCode = null
    )
}

@Embeddable
class CountryId(
    var comCode: String,
    var countryCode: String

) : Serializable

fun CountryEntity.convertToDto(): CountryDto {
    return CountryDto(
        comCode = this.id.comCode,
        countryCode = this.id.countryCode,
        countryText = this.countryText
    )
}
