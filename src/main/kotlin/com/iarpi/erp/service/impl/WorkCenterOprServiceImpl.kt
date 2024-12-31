package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.*
import com.iarpi.erp.repository.WorkCenterOprRepository
import com.iarpi.erp.service.WorkCenterOprService
import org.springframework.stereotype.Service

@Service
data class WorkCenterOprServiceImpl(val workCenterOprRepository: WorkCenterOprRepository) : WorkCenterOprService {

    override fun createNewWorkCenterOpr(request: CreateWorkCenterOprRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateWorkCenterOpr(request: UpdateWorkCenterOprRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteWorkCenterOprById(id: Long): String {
        TODO("Not yet implemented")
    }


}
