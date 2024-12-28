package com.iarpi.erp.model.entity

import com.iarpi.erp.model.dto.MaterialTextDto
import jakarta.persistence.*
import java.time.LocalDate


@Entity
@Table(name = "material_text")
data class MaterialTextEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "material_text_sequence")
    @SequenceGenerator(name = "material_text_sequence", sequenceName = "material_text_id_seq", allocationSize = 1)
    var id: Long?,

    @Column(name = "DOC_NUMBER", nullable = false)
    var docNumber: String,

    @Column(name = "MAT_DOC_FROM", nullable = false)
    var matDocFrom: LocalDate,

    @Column(name = "MAT_DOC_UNTIL", nullable = false)
    var matDocUntil: LocalDate,

    @Column(name = "MATS_TEXT", nullable = false)
    var matsText: String,

    @Column(name = "MATLT_TEXT", nullable = false)
    var matltText: String,

    @ManyToOne // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "COMPANY_ID", referencedColumnName = "id")
    var company: CompanyEntity,

    @ManyToOne // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "MAT_DOC_TYPE_ID", referencedColumnName = "id")
    var material: MaterialEntity,

    @ManyToOne // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "LAN_CODE_ID", referencedColumnName = "id")
    var language: LanguageEntity,

    @OneToOne(fetch = FetchType.LAZY) // burada join eklememe gerek olmayabilir ? Emin degilim
    @JoinColumn(name = "material_head_id", referencedColumnName = "id", nullable = false)
    var materialHead: MaterialHeadEntity?,
)

fun MaterialTextEntity.convertToDto(): MaterialTextDto {
    return MaterialTextDto(
        this.id ?: -1L,
        this.docNumber,
        this.matDocFrom,
        this.matDocUntil,
        this.matsText,
        this.matltText,
        this.company.id ?: -1L,
        this.material.id ?: -1L,
        this.language.id ?: -1L

    )
}