package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateMaterialRequest
import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.model.dto.control.MaterialDto

interface MaterialService {
    fun createMaterial(request: CreateMaterialRequest): MaterialDto
    fun updateMaterial(id: Long, request: UpdateMaterialRequest): MaterialDto
    fun deleteMaterialById(id: Long): String
    fun getAll(): List<MaterialDto>
    fun getById(id: Long): MaterialDto
}
