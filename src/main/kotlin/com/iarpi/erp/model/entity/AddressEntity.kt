package com.iarpi.erp.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "BSMGRIRPGEN0011")
data class AddressEntity(

    //todo: burada adresi de eklememiz lazım, burada gecici olarak adresi kaldirdik

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    @SequenceGenerator(name = "address_sequence", sequenceName = "bsmgrirpgen0011_id_seq", allocationSize = 1)
    val id: Long?,

    @Column(name = "ADDRESS1")
    val address1: String,

    @Column(name = "ADDRESS2")
    var address2: String,

    @OneToOne
    @JoinColumn(name = "COM_CODE_ID",referencedColumnName = "id")
    var companyEntity: CompanyEntity,

    @OneToOne
    @JoinColumn(name = "COUNTRY_CODE_ID",referencedColumnName = "id")
    var countryEntity: CountryEntity,

    @OneToOne
    @JoinColumn(name = "CITY_CODE_ID",referencedColumnName = "id")
    var cityEntity: CityEntity
)
