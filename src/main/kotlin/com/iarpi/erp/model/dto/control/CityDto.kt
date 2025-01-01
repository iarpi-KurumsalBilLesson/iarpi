package com.iarpi.erp.model.dto.control

data class CityDto(
    val id: Long?,
    val countryCode: String?, // CityEntity içerisinde country bağlantısından dolayı bu şekilde cozum bulduk
    val cityCode: String,  //ımmutable
    val cityText: String
)

