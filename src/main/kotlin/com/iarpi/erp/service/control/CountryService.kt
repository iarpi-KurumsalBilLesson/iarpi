package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.CountryDto

interface CountryService {
    fun getAll(): List<CountryDto>
    fun getById(id: Long): CountryDto
}
