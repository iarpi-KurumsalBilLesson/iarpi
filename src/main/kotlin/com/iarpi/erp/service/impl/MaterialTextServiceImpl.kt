package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateMaterialTextRequest
import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.repository.MaterialTextRepository
import com.iarpi.erp.service.MaterialTextService
import org.springframework.stereotype.Service

@Service
class MaterialTextServiceImpl(val materialHeadRepository: MaterialTextRepository) : MaterialTextService {

    override fun createNewMaterialText(request: CreateMaterialTextRequest) {
        TODO("Not yet implemented")
    }

    override fun updateMaterialText(request: UpdateMaterialTextRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteMaterialTextById(id: Long): String {
        TODO("Not yet implemented")
    }
}