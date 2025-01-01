package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateNewBomRequest
import com.iarpi.erp.controller.control.request.UpdateBomRequest
import com.iarpi.erp.controller.control.request.applyUpdatesTo
import com.iarpi.erp.controller.control.request.convertToEntity
import com.iarpi.erp.model.dto.control.BomDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.BomRepository
import com.iarpi.erp.service.control.BomService
import org.springframework.stereotype.Service

@Service
class BomServiceImpl(val bomRepository: BomRepository) : BomService {

    override fun createBom(request: CreateNewBomRequest): BomDto {
        val entity = request.convertToEntity()
        return bomRepository.save(entity).convertToDto()
    }

    override fun updateBom(id: Long, request: UpdateBomRequest): BomDto {
        val entity = bomRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val updatedEntity = request.applyUpdatesTo(entity)

        return bomRepository.save(updatedEntity).convertToDto()
    }

    override fun getAll(): List<BomDto> {
        return bomRepository.findAll().map { entity -> entity.convertToDto() }
    }

    override fun getById(id: Long): BomDto {
        return bomRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun deleteBomById(id: Long): String {
        if (bomRepository.existsById(id)) {
            bomRepository.deleteById(id)

            return "Record was deleted";
        }

        throw NotFoundException(id.toString())
    }
}
