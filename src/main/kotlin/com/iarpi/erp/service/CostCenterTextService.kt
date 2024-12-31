package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCostCenterTextRequest
import com.iarpi.erp.controller.request.UpdateCostCenterTextRequest

interface CostCenterTextService {
    fun createNewCostCenterText(request: CreateCostCenterTextRequest)
    fun updateCostCenterText(request: UpdateCostCenterTextRequest)
    fun deleteCostCenterTextById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}