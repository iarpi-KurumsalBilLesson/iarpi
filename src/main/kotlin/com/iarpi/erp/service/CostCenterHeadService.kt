package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest

interface CostCenterHeadService {
    fun createNewCostCenterHead(request: CreateCostCenterHeadRequest)
    fun updateCostCenterHead(request: UpdateCostCenterHeadRequest)
    fun deleteCostCenterHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}