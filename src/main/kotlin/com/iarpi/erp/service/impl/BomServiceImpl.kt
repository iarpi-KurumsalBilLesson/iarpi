package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateBomRequest
import com.iarpi.erp.controller.request.UpdateBomRequest
import com.iarpi.erp.repository.BomRepository
import com.iarpi.erp.service.BomService
import org.springframework.stereotype.Service

@Service
data class BomServiceImpl(val bomRepository: BomRepository) : BomService {

    override fun createBom(request: CreateBomRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateBom(request: UpdateBomRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteBomById(id: Long): String {
        TODO("Not yet implemented")
    }
}
