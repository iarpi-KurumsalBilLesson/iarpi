package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateWorkCenterRequest
import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.model.dto.control.WorkCenterDto

interface WorkCenterService {
    fun createWorkCenter(request: CreateWorkCenterRequest): WorkCenterDto
    fun updateWorkCenter(id: Long, request: UpdateWorkCenterRequest): WorkCenterDto
    fun deleteWorkCenterById(id: Long): String
    fun getAll(): List<WorkCenterDto>
    fun getById(id: Long): WorkCenterDto
}
