package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.request.CreateWorkCenterRequest


interface WorkCenterService {
    fun createWorkCenter(request: CreateWorkCenterRequest)
    fun updateWorkCenter(request: UpdateWorkCenterRequest)
    fun deleteWorkCenterById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
