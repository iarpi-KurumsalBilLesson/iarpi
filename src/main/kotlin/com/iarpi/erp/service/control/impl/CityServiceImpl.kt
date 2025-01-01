package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateCityRequest
import com.iarpi.erp.controller.control.request.UpdateCityRequest
import com.iarpi.erp.repository.control.CityRepository
import com.iarpi.erp.service.control.CityService
import org.springframework.stereotype.Service

@Service
data class CityServiceImpl(val cityRepository: CityRepository) : CityService {

    override fun createCity(request: CreateCityRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateCity(request: UpdateCityRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteCityById(id: Long): String {
        TODO("Not yet implemented")
    }


}
