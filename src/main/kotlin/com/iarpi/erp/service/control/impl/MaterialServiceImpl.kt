package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateMaterialRequest
import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.MaterialDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.MaterialRepository
import com.iarpi.erp.service.control.MaterialService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MaterialServiceImpl(
    private val materialRepository: MaterialRepository,
    private val companyRepository: CompanyRepository
) : MaterialService {

    @Transactional
    override fun createMaterial(request: CreateMaterialRequest): MaterialDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException("request.companyId.toString()") }
        
        val entity = request.convertToEntity(company)
        return materialRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateMaterial(id: Long, request: UpdateMaterialRequest): MaterialDto {
        val entity = materialRepository.findById(id)
            .orElseThrow { NotFoundException("id") }
        
        val updatedEntity = request.applyUpdatesTo(entity)
        return materialRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteMaterialById(id: Long): String {
        if (!materialRepository.existsById(id)) {
            throw NotFoundException("id")
        }
        materialRepository.deleteById(id)
        return "Material deleted successfully"
    }

    override fun getAll(): List<MaterialDto> {
        return materialRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): MaterialDto {
        return materialRepository.findById(id)
            .orElseThrow { NotFoundException("id") }
            .convertToDto()
    }
}
