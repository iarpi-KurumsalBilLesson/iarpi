package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.control.UnitDto
import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN005")
data class UnitEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unit_sequence")
    @SequenceGenerator(name = "unit_sequence", sequenceName = "bsmgrirpgen005_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "UNIT_CODE")
    var unitCode: String,

    @Column(name = "UNIT_TEXT")
    var unitText: String,

    @Column(name = "IS_MAIN_UNIT")
    var isMainUnit: Boolean,

    @Column(name = "MAIN_UNIT_CODE")
    var mainUnitCode: String,
)

fun UnitEntity.convertToDto(): UnitDto {
    return UnitDto(
        this.id,
        this.unitCode,
        this.unitText,
        this.isMainUnit,
        this.mainUnitCode
    )
}
