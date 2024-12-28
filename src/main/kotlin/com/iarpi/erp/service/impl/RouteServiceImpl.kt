package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.RouteDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.RouteRepository
import com.iarpi.erp.service.RouteService
import org.springframework.stereotype.Service

@Service
class RouteServiceImpl(val routeRepository: RouteRepository) : RouteService {
    override fun getAll(): List<RouteDto> {
        return routeRepository.findAll().map { entity -> entity.convertToDto() }

    }

    override fun createNewRoute(routeDto: RouteDto): RouteDto {
        val entity = routeDto.convertToEntity()
        val record = routeRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateRoute(id: Long, routeDto: RouteDto): RouteDto {
        val entity = routeRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = routeDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return routeRepository.save(mappedEntity).convertToDto()
    }

    override fun deleteRoute(id: Long): String {
        routeRepository.deleteById(id)

        return "Record was deleted"
    }

    override fun getById(id: Long): RouteDto {
        return routeRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()

    }
}