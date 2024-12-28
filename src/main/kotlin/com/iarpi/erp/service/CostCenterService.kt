package com.iarpi.erp.service

import com.iarpi.erp.model.dto.control.CostCenterDto

interface CostCenterService {

    fun getAll(): List<CostCenterDto>
    fun getById(id: Long): CostCenterDto
    fun createNewCostCenter(costCenter: CostCenterDto): CostCenterDto
    fun updateCostCenter(id: Long, costCenter: CostCenterDto): CostCenterDto
    fun deleteCostCenter(id: Long): String
}
