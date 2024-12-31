package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateBomContentRequest
import com.iarpi.erp.controller.request.UpdateBomContentRequest
import com.iarpi.erp.repository.BomContentRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.BomContentService

@Service
data class BomContentServiceImpl(val bomContentRepository : BomContentRepository) : BomContentService {
    override fun createNewBomContent(request: CreateBomContentRequest) {
        TODO("Not yet implemented")
    }

    override fun updateBomContent(request: UpdateBomContentRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun deleteBomContentById(id: Long): String {
        TODO("Not yet implemented")
    }
}
