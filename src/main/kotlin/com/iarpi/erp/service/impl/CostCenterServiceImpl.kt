package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.controller.request.UpdateCostCenterRequest
import com.iarpi.erp.repository.CostCenterRepository
import com.iarpi.erp.service.CostCenterService
import org.springframework.stereotype.Service

@Service
data class CostCenterServiceImpl(val costCenterRepository: CostCenterRepository) : CostCenterService {

    override fun createCostCenter(request: CreateCostCenterRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateCostCenter(request: UpdateCostCenterRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteCostCenterById(id: Long): String {
        TODO("Not yet implemented")
    }


}
