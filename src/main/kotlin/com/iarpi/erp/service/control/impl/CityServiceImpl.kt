package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.CityDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CityRepository
import com.iarpi.erp.service.control.CityService
import org.springframework.stereotype.Service

@Service
class CityServiceImpl(
    private val cityRepository: CityRepository
) : CityService {

    override fun getAll(): List<CityDto> {
        return cityRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): CityDto {
        return cityRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
}
