package com.iarpi.erp.service

import com.iarpi.erp.model.dto.UnitDto

interface UnitService {

    fun getAll(): List<UnitDto>

    fun createNewUnit(unitDto : UnitDto) : UnitDto
    fun updateUnit(id: Long, unitDto: UnitDto) : UnitDto
    fun deleteUnit (id : Long) : String
    fun getById(id: Long): UnitDto

}
