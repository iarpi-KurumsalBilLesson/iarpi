package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateCityRequest
import com.iarpi.erp.controller.control.request.UpdateCityRequest


interface CityService {
    fun createCity(request: CreateCityRequest)
    fun updateCity(request: UpdateCityRequest)
    fun deleteCityById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
