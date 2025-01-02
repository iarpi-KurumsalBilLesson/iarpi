package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateNewBomRequest
import com.iarpi.erp.controller.control.request.UpdateBomRequest
import com.iarpi.erp.model.dto.control.BomDto


interface BomService {
    fun createBom(request: CreateNewBomRequest): BomDto
    fun updateBom(id: Long, request: UpdateBomRequest): BomDto
    fun deleteBomById(id: Long): String
    fun getAll(): List<BomDto>
    fun getById(id: Long): BomDto
    fun getAllByCompanyId(id: Long): List<BomDto>
}
