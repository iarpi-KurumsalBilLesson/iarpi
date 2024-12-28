package com.iarpi.erp.service

import com.iarpi.erp.model.dto.control.CountryDto
import com.iarpi.erp.model.entity.CountryEntity

interface CountryService {

    fun getAll(): List<CountryDto>
    fun getById(id: Long): CountryDto
    fun getByCountryCode(lanCode: String): CountryDto
    fun getAllEntity(): List<CountryEntity>

}
