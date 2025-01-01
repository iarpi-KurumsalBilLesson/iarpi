package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.controller.control.request.UpdateCostCenterRequest
import com.iarpi.erp.repository.control.CostCenterRepository
import com.iarpi.erp.service.control.CostCenterService
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
