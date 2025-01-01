package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.controller.control.request.UpdateCostCenterRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.controller.request.convertToEntity
import com.iarpi.erp.model.dto.control.CostCenterDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CostCenterRepository
import com.iarpi.erp.service.control.CostCenterService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CostCenterServiceImpl(
    private val costCenterRepository: CostCenterRepository
) : CostCenterService {

    @Transactional
    override fun createCostCenter(request: CreateCostCenterRequest): CostCenterDto {
        val entity = request.convertToEntity()
        return costCenterRepository.save(entity).convertToDto()
    }

    @Transactional
    override fun updateCostCenter(id: Long, request: UpdateCostCenterRequest): CostCenterDto {
        val entity = costCenterRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
        val updatedEntity = request.applyUpdatesTo(entity)
        return costCenterRepository.save(updatedEntity).convertToDto()
    }

    @Transactional
    override fun deleteCostCenterById(id: Long): String {
        if (costCenterRepository.existsById(id)) {
            costCenterRepository.deleteById(id)
            return "Record was deleted"
        }
        throw NotFoundException(id.toString())
    }

    override fun getAll(): List<CostCenterDto> {
        return costCenterRepository.findAll().map { entity -> entity.convertToDto() }
    }

    override fun getById(id: Long): CostCenterDto {
        return costCenterRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
}
