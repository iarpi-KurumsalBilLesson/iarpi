package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.CityDto


interface CityService {

    fun getAll(): List<CityDto>
    fun getByCityCode(lanCode: String): CityDto

}
