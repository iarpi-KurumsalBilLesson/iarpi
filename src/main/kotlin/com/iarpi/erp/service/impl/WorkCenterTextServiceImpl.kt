package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateWorkCenterTextRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterTextRequest
import com.iarpi.erp.repository.WorkCenterTextRepository
import com.iarpi.erp.service.WorkCenterTextService
import org.springframework.stereotype.Service

@Service
data class WorkCenterTextServiceImpl(val workCenterTextRepository: WorkCenterTextRepository) : WorkCenterTextService {

    override fun createNewWorkCenterText(request: CreateWorkCenterTextRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateWorkCenterText(request: UpdateWorkCenterTextRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteWorkCenterTextById(id: Long): String {
        TODO("Not yet implemented")
    }

}
