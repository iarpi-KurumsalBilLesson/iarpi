package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.LanguageDto
import jakarta.persistence.*
import lombok.Setter
import java.io.Serializable

@Entity
@Table(name = "BSMGRIRPGEN002")
@Setter
data class LanguageEntity(

    @EmbeddedId
    val id: LanguageId,

    @Column(name = "LAN_TEXT", nullable = false)
    var lanText: String,

    @MapsId("comCode")
    @ManyToOne
    @JoinColumn(name = "COM_CODE")
    val comCode: CompanyEntity?
) {
    constructor(lanText: String, id: LanguageId) : this(
        lanText = lanText,
        id = id,
        comCode = null
    )
}

@Embeddable
class LanguageId(
    var comCode: String,
    var lanCode: String

) : Serializable

fun LanguageEntity.convertToDto(): LanguageDto {
    return LanguageDto(
        comCode = this.id.comCode,
        lanCode = this.id.lanCode,
        lanText = this.lanText
    )
}
