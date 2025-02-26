package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.WorkCenterDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.WorkCenterRepository
import com.iarpi.erp.service.control.WorkCenterService
import org.springframework.stereotype.Service

@Service
class WorkCenterServiceImpl(val workCenterRepository: WorkCenterRepository) : WorkCenterService {
    override fun getAll(): List<WorkCenterDto> {
        return workCenterRepository.findAll().map { entity -> entity.convertToDto() }

    }

    override fun getById(id: Long): WorkCenterDto {
        return workCenterRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()

    }

    override fun createNewWorkCenter(workCenterDto: WorkCenterDto): WorkCenterDto {
        val entity = workCenterDto.convertToEntity()
        val record = workCenterRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateWorkCenter(id: Long, workCenterDto: WorkCenterDto): WorkCenterDto {
        val entity = workCenterRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = workCenterDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return workCenterRepository.save(mappedEntity).convertToDto()
    }

    override fun deleteWorkCenter(id: Long): String {
        workCenterRepository.deleteById(id)

        return "Record was deleted"
    }
}