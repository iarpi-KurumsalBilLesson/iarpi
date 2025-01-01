package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateWorkCenterRequest
import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.WorkCenterDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.WorkCenterRepository
import com.iarpi.erp.service.control.WorkCenterService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WorkCenterServiceImpl(
    private val workCenterRepository: WorkCenterRepository,
    private val companyRepository: CompanyRepository
) : WorkCenterService {

    @Transactional
    override fun createWorkCenter(request: CreateWorkCenterRequest): WorkCenterDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException(request.companyId.toString()) }

        val entity = request.convertToEntity(company)
        return workCenterRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateWorkCenter(id: Long, request: UpdateWorkCenterRequest): WorkCenterDto {
        val entity = workCenterRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }

        val updatedEntity = request.applyUpdatesTo(entity)
        return workCenterRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteWorkCenterById(id: Long): String {
        if (!workCenterRepository.existsById(id)) {
            throw NotFoundException(id.toString())
        }
        workCenterRepository.deleteById(id)
        return "WorkCenter deleted successfully"
    }

    override fun getAll(): List<WorkCenterDto> {
        return workCenterRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): WorkCenterDto {
        return workCenterRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
}