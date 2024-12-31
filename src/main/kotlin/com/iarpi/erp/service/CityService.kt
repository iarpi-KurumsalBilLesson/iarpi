package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCityRequest
import com.iarpi.erp.controller.request.UpdateCityRequest


interface CityService {
    fun createCity(request: CreateCityRequest)
    fun updateCity(request: UpdateCityRequest)
    fun deleteCityById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
