package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.control.MaterialControlDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.MaterialEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialRepository
import com.iarpi.erp.service.MaterialService
import org.springframework.stereotype.Service

@Service
class MaterialServiceImpl(val materialRepository: MaterialRepository) : MaterialService {
    override fun getAll(): List<MaterialControlDto> {
        return materialRepository.findAll().map { entity -> entity.convertToDto() }
    }

    override fun createNewMaterial(materialControlDto: MaterialControlDto): MaterialControlDto {
        val entity = materialControlDto.convertToEntity()
        val record = materialRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateMaterial(id: Long, materialControlDto: MaterialControlDto): MaterialControlDto {
        val entity = materialRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = materialControlDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return materialRepository.save(mappedEntity).convertToDto()
    }

    override fun getById(id: Long): MaterialControlDto {
        return materialRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun deleteMaterial(id: Long): String {
        materialRepository.deleteById(id)

        return "Record was deleted"
    }

    override fun findById(id: Long): MaterialEntity {
        return materialRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
    }
}