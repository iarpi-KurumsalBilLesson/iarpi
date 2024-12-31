package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateUnitRequest
import com.iarpi.erp.controller.request.UpdateUnitRequest
import com.iarpi.erp.repository.UnitRepository
import com.iarpi.erp.service.UnitService
import org.springframework.stereotype.Service

@Service
data class UnitServiceImpl(val unitRepository: UnitRepository) : UnitService {

    override fun createUnit(request: CreateUnitRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateUnit(request: UpdateUnitRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteUnitById(id: Long): String {
        TODO("Not yet implemented")
    }

}
