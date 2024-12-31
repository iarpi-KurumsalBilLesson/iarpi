package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateOperationRequest
import com.iarpi.erp.controller.request.CreateOperationRequest


interface OperationService {
    fun createOperation(request: CreateOperationRequest)
    fun updateOperation(request: UpdateOperationRequest)
    fun deleteOperationById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
