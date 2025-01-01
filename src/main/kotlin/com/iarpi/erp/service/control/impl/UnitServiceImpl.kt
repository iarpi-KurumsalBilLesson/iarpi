package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateUnitRequest
import com.iarpi.erp.controller.control.request.UpdateUnitRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.UnitDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.UnitRepository
import com.iarpi.erp.service.control.UnitService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UnitServiceImpl(
    private val unitRepository: UnitRepository,
    private val companyRepository: CompanyRepository
) : UnitService {

    @Transactional
    override fun createUnit(request: CreateUnitRequest): UnitDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException(request.companyId.toString()) }

        val entity = request.convertToEntity(company)
        return unitRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateUnit(id: Long, request: UpdateUnitRequest): UnitDto {
        val entity = unitRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }

        val updatedEntity = request.applyUpdatesTo(entity)
        return unitRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteUnitById(id: Long): String {
        if (!unitRepository.existsById(id)) {
            throw NotFoundException(id.toString())
        }
        unitRepository.deleteById(id)
        return "Unit deleted successfully"
    }

    override fun getAll(): List<UnitDto> {
        return unitRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): UnitDto {
        return unitRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
} 