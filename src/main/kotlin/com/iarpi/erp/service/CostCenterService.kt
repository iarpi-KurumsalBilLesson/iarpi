package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.controller.request.UpdateCostCenterRequest


interface CostCenterService {
    fun createCostCenter(request: CreateCostCenterRequest)
    fun updateCostCenter(request: UpdateCostCenterRequest)
    fun deleteCostCenterById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
