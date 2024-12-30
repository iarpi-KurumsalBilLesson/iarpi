package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.service.MaterialHeadService
import org.springframework.stereotype.Service

@Service
class MaterialHeadServiceImpl(val materialHeadRepository: MaterialHeadRepository) : MaterialHeadService {

    override fun createNewMaterialHead(request: CreateMaterialHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun updateMaterialHead(request: UpdateMaterialHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteMaterialHeadById(id: Long): String {
        materialHeadRepository.deleteById(id)

        return "Record was deleted"
    }

    override fun getAll() {
        materialHeadRepository.findAll()
    }

    override fun getById(id: Long) {
    }
}