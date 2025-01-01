package com.iarpi.erp.model.entity.control

import jakarta.persistence.*
import lombok.Setter

@Entity
@Table(name = "BSMGRIRPGEN002")
@Setter
data class LanguageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costCenter_sequence")
    @SequenceGenerator(name = "costCenter_sequence", sequenceName = "bsmgrirpgen002_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "LAN_CODE", nullable = false)
    var lanCode: String,

    @Column(name = "LAN_TEXT", nullable = false)
    var lanText: String
)

