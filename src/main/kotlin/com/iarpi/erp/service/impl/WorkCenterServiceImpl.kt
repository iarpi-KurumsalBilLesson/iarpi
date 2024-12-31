package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateWorkCenterRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterRequest
import com.iarpi.erp.repository.WorkCenterRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.WorkCenterService

@Service
data class WorkCenterServiceImpl(val workCenterRepository: WorkCenterRepository) : WorkCenterService{

    override fun createWorkCenter(request: CreateWorkCenterRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateWorkCenter(request: UpdateWorkCenterRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteWorkCenterById(id: Long): String {
        TODO("Not yet implemented")
    }

}
