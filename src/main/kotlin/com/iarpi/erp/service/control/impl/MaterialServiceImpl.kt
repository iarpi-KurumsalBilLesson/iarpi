package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateMaterialRequest
import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.repository.control.MaterialRepository
import com.iarpi.erp.service.control.MaterialService
import org.springframework.stereotype.Service

@Service
data class MaterialServiceImpl(val materialRepository: MaterialRepository) : MaterialService {

    override fun createMaterial(request: CreateMaterialRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateMaterial(request: UpdateMaterialRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteMaterialById(id: Long): String {
        TODO("Not yet implemented")
    }


}
