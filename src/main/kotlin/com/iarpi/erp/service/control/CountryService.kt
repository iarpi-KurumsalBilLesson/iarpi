package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateCountryRequest
import com.iarpi.erp.controller.control.request.UpdateCountryRequest


interface CountryService {
    fun createCountry(request: CreateCountryRequest)
    fun updateCountry(request: UpdateCountryRequest)
    fun deleteCountryById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
