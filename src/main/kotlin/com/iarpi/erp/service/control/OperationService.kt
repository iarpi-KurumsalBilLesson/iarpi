package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateOperationRequest
import com.iarpi.erp.controller.control.request.UpdateOperationRequest
import com.iarpi.erp.model.dto.control.OperationDto

interface OperationService {
    fun createOperation(request: CreateOperationRequest): OperationDto
    fun updateOperation(id: Long, request: UpdateOperationRequest): OperationDto
    fun deleteOperationById(id: Long): String
    fun getAll(): List<OperationDto>
    fun getById(id: Long): OperationDto
}
