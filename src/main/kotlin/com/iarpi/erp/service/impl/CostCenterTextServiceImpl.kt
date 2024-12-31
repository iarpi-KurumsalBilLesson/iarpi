package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCostCenterTextRequest
import com.iarpi.erp.controller.request.UpdateCostCenterTextRequest
import com.iarpi.erp.repository.CostCenterTextRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.CostCenterTextService

@Service
 class CostCenterTextServiceImpl(val costCenterTextRepository: CostCenterTextRepository) : CostCenterTextService {

    override fun createNewCostCenterText(request: CreateCostCenterTextRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateCostCenterText(request: UpdateCostCenterTextRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteCostCenterTextById(id: Long): String {
        TODO("Not yet implemented")
    }
}