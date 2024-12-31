package com.iarpi.erp.model.entity.control

import jakarta.persistence.*
import lombok.Setter

@Entity
@Table(name = "BSMGRIRPGEN002")
@Setter
data class LanguageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long?,

    @Column(name = "LAN_CODE", nullable = false)
    var lanCode: String,

    @Column(name = "LAN_TEXT", nullable = false)
    var lanText: String
) {
    constructor(lanCode: String, lanText: String) : this(null, lanCode, lanText)
}

