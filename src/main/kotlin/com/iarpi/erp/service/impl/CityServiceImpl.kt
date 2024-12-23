package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.CityDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CityRepository
import com.iarpi.erp.service.CityService
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