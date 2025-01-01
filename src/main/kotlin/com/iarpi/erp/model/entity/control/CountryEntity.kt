package com.iarpi.erp.model.entity.control

import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN003")
data class CountryEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "costCenter_sequence")
    @SequenceGenerator(name = "costCenter_sequence", sequenceName = "bsmgrirpgen003_id_seq", allocationSize = 1)
    val id: Long,

    @Column(name = "COUNTRY_CODE", nullable = false)
    var countryCode: String,

    @Column(name = "COUNTRY_TEXT", nullable = false)
    var countryText: String,

    @OneToMany(mappedBy = "country", targetEntity = CityEntity::class, fetch = FetchType.EAGER)
    var city: List<CityEntity> = mutableListOf()
)


