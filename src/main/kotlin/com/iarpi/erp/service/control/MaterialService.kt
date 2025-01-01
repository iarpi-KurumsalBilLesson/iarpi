package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.controller.control.request.CreateMaterialRequest


interface MaterialService {
    fun createMaterial(request: CreateMaterialRequest)
    fun updateMaterial(request: UpdateMaterialRequest)
    fun deleteMaterialById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
