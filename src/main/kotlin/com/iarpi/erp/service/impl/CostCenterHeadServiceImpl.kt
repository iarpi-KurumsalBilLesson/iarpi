package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest
import com.iarpi.erp.repository.CostCenterHeadRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.CostCenterHeadService

@Service
class CostCenterHeadServiceImpl(val costCenterHeadRepository: CostCenterHeadRepository) : CostCenterHeadService {

    override fun createNewCostCenterHead(request: CreateCostCenterHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun updateCostCenterHead(request: UpdateCostCenterHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteCostCenterHeadById(id: Long): String {
        TODO("Not yet implemented")
    }
}