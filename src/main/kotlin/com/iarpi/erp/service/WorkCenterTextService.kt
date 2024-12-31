package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateWorkCenterTextRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterTextRequest

interface WorkCenterTextService {
    fun createNewWorkCenterText(request: CreateWorkCenterTextRequest)
    fun updateWorkCenterText(request: UpdateWorkCenterTextRequest)
    fun deleteWorkCenterTextById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}