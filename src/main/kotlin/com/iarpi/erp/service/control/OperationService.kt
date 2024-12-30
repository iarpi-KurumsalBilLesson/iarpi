package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.OperationDto

interface OperationService {
    fun getAll(): List<OperationDto>
    fun getById(id: Long): OperationDto
    fun createNewOperation(operationDto: OperationDto): OperationDto
    fun updateOperation(id: Long, operationDto: OperationDto): OperationDto
    fun deleteOperation(id: Long): String
}
