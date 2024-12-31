package com.iarpi.erp.model.entity.control

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE])
    var country: CountryEntity?
)
