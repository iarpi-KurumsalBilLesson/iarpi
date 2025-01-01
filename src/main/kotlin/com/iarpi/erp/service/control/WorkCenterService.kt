package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.control.request.CreateWorkCenterRequest


interface WorkCenterService {
    fun createWorkCenter(request: CreateWorkCenterRequest)
    fun updateWorkCenter(request: UpdateWorkCenterRequest)
    fun deleteWorkCenterById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
