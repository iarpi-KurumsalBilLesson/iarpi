package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.*
import com.iarpi.erp.repository.RotBomContentRepository
import com.iarpi.erp.repository.RotHeadRepository
import com.iarpi.erp.service.RotBomContentService
import com.iarpi.erp.service.RotHeadService
import org.springframework.stereotype.Service

@Service
data class RotHeadServiceImpl(val rotHeadRepository: RotHeadRepository) : RotHeadService {

    override fun createNewRotHead(request: CreateRotHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateRotHead(request: UpdateRotHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteRotHeadById(id: Long): String {
        TODO("Not yet implemented")
    }

}
