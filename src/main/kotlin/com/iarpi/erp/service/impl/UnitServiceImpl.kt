package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.control.UnitDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.UnitEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.UnitRepository
import com.iarpi.erp.service.UnitService
import org.springframework.stereotype.Service

@Service
class UnitServiceImpl(val unitRepository: UnitRepository) : UnitService {


    override fun getAll(): List<UnitDto> {
        return unitRepository.findAll().map { unit -> unit.convertToDto() }
    }

    override fun createNewUnit(unitDto: UnitDto): UnitDto {
        val entity = unitDto.convertToEntity()
        val record = unitRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateUnit(id: Long, unitDto: UnitDto): UnitDto {
        val entity = unitRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        val mappedEntity = unitDto.convertToEntity(entity.unitCode)
        mappedEntity.id = entity.id
        return unitRepository.save(mappedEntity).convertToDto()
    }

    override fun getById(id: Long): UnitDto {
        return unitRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }.convertToDto()
    }

    override fun findById(id: Long) : UnitEntity{
        return unitRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
    }

    override fun deleteUnit(id: Long): String {
        unitRepository.deleteById(id)

        return "Record was deleted"
    }
}