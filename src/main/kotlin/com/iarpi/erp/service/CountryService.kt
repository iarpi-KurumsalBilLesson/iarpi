package com.iarpi.erp.service

import com.iarpi.erp.model.dto.CountryDto

interface CountryService {

    fun createNewCountry(country: CountryDto): CountryDto
    fun updateCountry(country: CountryDto): CountryDto
    fun deleteCountry(country: CountryDto): String
    fun getAll(): List<CountryDto>
    fun getByCountryCode(lanCode: String): CountryDto
    fun getByComCode(comCode: String): CountryDto

}
