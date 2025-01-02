package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest
import com.iarpi.erp.model.dto.CostCenterHeadDto

interface CostCenterHeadService {
    fun createNewCostCenterHead(request: CreateCostCenterHeadRequest): CostCenterHeadDto
    fun updateCostCenterHead(id: Long, request: UpdateCostCenterHeadRequest) : CostCenterHeadDto
    fun deleteCostCenterHeadById(id: Long): String
    fun getAll() : List<CostCenterHeadDto>
    fun getById(id: Long) : CostCenterHeadDto
}