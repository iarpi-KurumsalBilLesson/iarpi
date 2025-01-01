package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateCostCenterRequest
import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.model.dto.control.CostCenterDto

interface CostCenterService {
    fun createCostCenter(request: CreateCostCenterRequest): CostCenterDto
    fun updateCostCenter(id: Long, request: UpdateCostCenterRequest): CostCenterDto
    fun deleteCostCenterById(id: Long): String
    fun getAll(): List<CostCenterDto>
    fun getById(id: Long): CostCenterDto
}
