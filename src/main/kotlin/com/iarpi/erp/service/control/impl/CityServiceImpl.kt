package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.CityDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CityRepository
import com.iarpi.erp.service.control.CityService
import org.springframework.stereotype.Service

@Service
class CityServiceImpl(
    var repository: CityRepository,
) : CityService {

    override fun getAll(): List<CityDto> {
        return repository.findAll().map { item -> item.convertToDto() }
    }

    override fun getByCityCode(cityCode: String): CityDto {
        val entity = repository.findByCityCode(cityCode).orElseThrow {
            NotFoundException(cityCode)
        }

        return entity.convertToDto()
    }
}