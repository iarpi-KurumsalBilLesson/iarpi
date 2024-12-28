package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.CostCenterDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CostCenterRepository
import com.iarpi.erp.service.CostCenterService
import org.springframework.stereotype.Service

@Service
class CostCenterServiceImpl(val costCenterRepository: CostCenterRepository) : CostCenterService {
    override fun getAll(): List<CostCenterDto> {
        return costCenterRepository.findAll().map { entity -> entity.convertToDto() }

    }

    override fun getById(id: Long): CostCenterDto {
        return costCenterRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun createNewCostCenter(costCenterDto: CostCenterDto): CostCenterDto {
        val entity = costCenterDto.convertToEntity()
        val record = costCenterRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateCostCenter(id: Long, costCenterDto: CostCenterDto): CostCenterDto {
        val entity = costCenterRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = costCenterDto.convertToEntity()
        mappedEntity.id = entity.id
        return costCenterRepository.save(mappedEntity).convertToDto()
    }

    override fun deleteCostCenter(id: Long): String {
        costCenterRepository.deleteById(id)

        return "Record was deleted"
    }
}