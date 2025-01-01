package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateRouteRequest
import com.iarpi.erp.controller.control.request.UpdateRouteRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.RouteDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.RouteRepository
import com.iarpi.erp.service.control.RouteService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class RouteServiceImpl(
    private val routeRepository: RouteRepository,
    private val companyRepository: CompanyRepository
) : RouteService {

    @Transactional
    override fun createRoute(request: CreateRouteRequest): RouteDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException("Company not found with id: ${request.companyId}") }
        
        val entity = request.convertToEntity(company)
        return routeRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateRoute(id: Long, request: UpdateRouteRequest): RouteDto {
        val entity = routeRepository.findById(id)
            .orElseThrow { NotFoundException("Route not found with id: $id") }
        
        val updatedEntity = request.applyUpdatesTo(entity)
        return routeRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteRouteById(id: Long): String {
        if (!routeRepository.existsById(id)) {
            throw NotFoundException("Route not found with id: $id")
        }
        routeRepository.deleteById(id)
        return "Route deleted successfully"
    }

    override fun getAll(): List<RouteDto> {
        return routeRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): RouteDto {
        return routeRepository.findById(id)
            .orElseThrow { NotFoundException("Route not found with id: $id") }
            .convertToDto()
    }
}
