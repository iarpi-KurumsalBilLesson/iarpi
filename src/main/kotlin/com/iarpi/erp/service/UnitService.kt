package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateUnitRequest
import com.iarpi.erp.controller.request.CreateUnitRequest


interface UnitService {
    fun createUnit(request: CreateUnitRequest)
    fun updateUnit(request: UpdateUnitRequest)
    fun deleteUnitById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
