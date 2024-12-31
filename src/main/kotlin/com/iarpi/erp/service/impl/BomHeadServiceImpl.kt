package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.repository.BomHeadRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.BomHeadService

@Service
data class BomHeadServiceImpl(val bomHeadRepository: BomHeadRepository) : BomHeadService{

    override fun createNewBomHead(request: CreateBomHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateBomHead(request: UpdateBomHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteBomHeadById(id: Long): String {
        TODO("Not yet implemented")
    }
}
