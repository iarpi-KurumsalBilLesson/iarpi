package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateRotBomContentRequest
import com.iarpi.erp.controller.request.UpdateRotBomContentRequest
import com.iarpi.erp.repository.RotBomContentRepository
import com.iarpi.erp.service.RotBomContentService
import org.springframework.stereotype.Service

@Service
data class RotBomContentServiceImpl(val rotBomContentRepository: RotBomContentRepository) : RotBomContentService {

    override fun createNewRotBomContent(request: CreateRotBomContentRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateRotBomContent(request: UpdateRotBomContentRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteRotBomContentById(id: Long): String {
        TODO("Not yet implemented")
    }
}
