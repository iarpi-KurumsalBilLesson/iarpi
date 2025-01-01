package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateOperationRequest
import com.iarpi.erp.controller.control.request.UpdateOperationRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.OperationDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.OperationRepository
import com.iarpi.erp.service.control.OperationService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class OperationServiceImpl(
    private val operationRepository: OperationRepository,
    private val companyRepository: CompanyRepository
) : OperationService {

    @Transactional
    override fun createOperation(request: CreateOperationRequest): OperationDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException("request.companyId.toString()") }

        val entity = request.convertToEntity(company)
        return operationRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateOperation(id: Long, request: UpdateOperationRequest): OperationDto {
        val entity = operationRepository.findById(id)
            .orElseThrow { NotFoundException("id.toString()") }

        val updatedEntity = request.applyUpdatesTo(entity)
        return operationRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteOperationById(id: Long): String {
        if (!operationRepository.existsById(id)) {
            throw NotFoundException("id.toString()")
        }
        operationRepository.deleteById(id)
        return "Operation deleted successfully"
    }

    override fun getAll(): List<OperationDto> {
        return operationRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): OperationDto {
        return operationRepository.findById(id)
            .orElseThrow { NotFoundException("id.toString()") }
            .convertToDto()
    }
}
