package com.iarpi.erp.service

import com.iarpi.erp.model.dto.CityDto


interface CityService {

    fun getAll(): List<CityDto>
    fun getByCityCode(lanCode: String): CityDto

}
