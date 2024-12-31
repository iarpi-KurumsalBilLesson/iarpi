package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.*
import com.iarpi.erp.repository.RotOprContentRepository
import com.iarpi.erp.service.RotHeadService
import com.iarpi.erp.service.RotOprContentService
import org.springframework.stereotype.Service

@Service
data class RotOprContentServiceImpl(val rotHeadRepository: RotOprContentRepository) : RotOprContentService {

    override fun createNewRotOprContent(request: CreateRotOprContentRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateRotOprContent(request: UpdateRotOprContentRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteRotOprContentById(id: Long): String {
        TODO("Not yet implemented")
    }


}
