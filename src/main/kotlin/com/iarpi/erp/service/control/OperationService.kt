package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateOperationRequest
import com.iarpi.erp.controller.control.request.CreateOperationRequest


interface OperationService {
    fun createOperation(request: CreateOperationRequest)
    fun updateOperation(request: UpdateOperationRequest)
    fun deleteOperationById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
