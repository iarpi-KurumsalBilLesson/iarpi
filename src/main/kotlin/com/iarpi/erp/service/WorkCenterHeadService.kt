package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateWorkCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterHeadRequest

interface WorkCenterHeadService {
    fun createNewWorkCenterHead(request: CreateWorkCenterHeadRequest)
    fun updateWorkCenterHead(request: UpdateWorkCenterHeadRequest)
    fun deleteWorkCenterHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}