package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.OperationDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.OperationRepository
import com.iarpi.erp.service.control.OperationService
import org.springframework.stereotype.Service

@Service
class OperationServiceImpl(val operationRepository: OperationRepository) : OperationService {
    override fun getAll(): List<OperationDto> {
        return operationRepository.findAll().map { entity -> entity.convertToDto() }

    }

    override fun getById(id: Long): OperationDto {
        return operationRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun createNewOperation(operationDto: OperationDto): OperationDto {
        val entity = operationDto.convertToEntity()
        val record = operationRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateOperation(id: Long, operationDto: OperationDto): OperationDto {
        val entity = operationRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = operationDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return operationRepository.save(mappedEntity).convertToDto()
    }

    override fun deleteOperation(id: Long): String {
        operationRepository.deleteById(id)

        return "Record was deleted"
    }
}