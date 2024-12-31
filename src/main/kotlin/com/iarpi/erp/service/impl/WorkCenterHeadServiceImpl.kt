package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.*
import com.iarpi.erp.repository.WorkCenterHeadRepository
import com.iarpi.erp.service.WorkCenterHeadService
import org.springframework.stereotype.Service

@Service
data class WorkCenterHeadServiceImpl(val workCenterHeadRepository: WorkCenterHeadRepository) : WorkCenterHeadService {

    override fun createNewWorkCenterHead(request: CreateWorkCenterHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateWorkCenterHead(request: UpdateWorkCenterHeadRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteWorkCenterHeadById(id: Long): String {
        TODO("Not yet implemented")
    }

}
