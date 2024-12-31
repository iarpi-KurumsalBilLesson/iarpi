package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateWorkCenterOprRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterOprRequest

interface WorkCenterOprService {
    fun createNewWorkCenterOpr(request: CreateWorkCenterOprRequest)
    fun updateWorkCenterOpr(request: UpdateWorkCenterOprRequest)
    fun deleteWorkCenterOprById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}