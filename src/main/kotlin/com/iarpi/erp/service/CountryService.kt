package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCountryRequest
import com.iarpi.erp.controller.request.UpdateCountryRequest


interface CountryService {
    fun createCountry(request: CreateCountryRequest)
    fun updateCountry(request: UpdateCountryRequest)
    fun deleteCountryById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
