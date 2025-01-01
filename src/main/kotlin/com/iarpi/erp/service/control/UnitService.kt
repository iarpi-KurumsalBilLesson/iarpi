package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateUnitRequest
import com.iarpi.erp.controller.control.request.CreateUnitRequest


interface UnitService {
    fun createUnit(request: CreateUnitRequest)
    fun updateUnit(request: UpdateUnitRequest)
    fun deleteUnitById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
