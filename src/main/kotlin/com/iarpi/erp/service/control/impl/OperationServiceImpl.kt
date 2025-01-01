package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateOperationRequest
import com.iarpi.erp.controller.control.request.UpdateOperationRequest
import com.iarpi.erp.repository.control.OperationRepository
import com.iarpi.erp.service.control.OperationService
import org.springframework.stereotype.Service

@Service
data class OperationServiceImpl(val operationRepository: OperationRepository) : OperationService {

    override fun createOperation(request: CreateOperationRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateOperation(request: UpdateOperationRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteOperationById(id: Long): String {
        TODO("Not yet implemented")
    }
}
