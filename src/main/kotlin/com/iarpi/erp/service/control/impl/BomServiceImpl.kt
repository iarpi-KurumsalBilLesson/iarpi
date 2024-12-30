package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.BomDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.control.BomEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.BomRepository
import com.iarpi.erp.service.control.BomService
import org.springframework.stereotype.Service

@Service
class BomServiceImpl(val bomRepository: BomRepository) : BomService {
    override fun getAll(): List<BomDto> {
        return bomRepository.findAll().map { entity -> entity.convertToDto() }

    }

    override fun getById(id: Long): BomDto {
        return bomRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun createNewBom(bomDto: BomDto): BomDto {
        val entity = bomDto.convertToEntity()
        val record = bomRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateBom(id: Long, bomDto: BomDto): BomDto {
        val entity = bomRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = bomDto.convertToEntity(entity.docType)
        mappedEntity.id = entity.id
        return bomRepository.save(mappedEntity).convertToDto()
    }

    override fun deleteBom(id: Long): String {
        bomRepository.deleteById(id)

        return "Record was deleted"
    }

    override fun findById(id: Long): BomEntity {
        return bomRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
    }
}