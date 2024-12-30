package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.UnitDto
import com.iarpi.erp.model.entity.control.UnitEntity

interface UnitService {

    fun getAll(): List<UnitDto>

    fun createNewUnit(unitDto: UnitDto): UnitDto
    fun updateUnit(id: Long, unitDto: UnitDto): UnitDto
    fun deleteUnit(id: Long): String
    fun getById(id: Long): UnitDto
    fun findById(id: Long) : UnitEntity

}
