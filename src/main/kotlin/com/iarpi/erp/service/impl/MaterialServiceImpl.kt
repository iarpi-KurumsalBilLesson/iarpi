package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialRepository
import com.iarpi.erp.service.MaterialService
import org.springframework.stereotype.Service

@Service
class MaterialServiceImpl(val materialRepository: MaterialRepository) : MaterialService {
    override fun getAll(): List<MaterialDto> {
        return materialRepository.findAll().map { entity -> entity.convertToDto() }
    }

    override fun createNewMaterial(materialDto: MaterialDto): MaterialDto {
        val entity = materialDto.convertToEntity()
        val record = materialRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateMaterial(id: Long, materialDto: MaterialDto): MaterialDto {
        val entity = materialRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = materialDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return materialRepository.save(mappedEntity).convertToDto()
    }

    override fun getById(id: Long): MaterialDto {
        return materialRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun deleteMaterial(id: Long): String {
        materialRepository.deleteById(id)

        return "Record was deleted"
    }
}