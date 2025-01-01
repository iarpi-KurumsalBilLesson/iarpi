package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateUnitRequest
import com.iarpi.erp.controller.control.request.UpdateUnitRequest
import com.iarpi.erp.model.dto.control.UnitDto

interface UnitService {
    fun createUnit(request: CreateUnitRequest): UnitDto
    fun updateUnit(id: Long, request: UpdateUnitRequest): UnitDto
    fun deleteUnitById(id: Long): String
    fun getAll(): List<UnitDto>
    fun getById(id: Long): UnitDto
}
