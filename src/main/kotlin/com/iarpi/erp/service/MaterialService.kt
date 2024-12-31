package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateMaterialRequest
import com.iarpi.erp.controller.request.CreateMaterialRequest


interface MaterialService {
    fun createMaterial(request: CreateMaterialRequest)
    fun updateMaterial(request: UpdateMaterialRequest)
    fun deleteMaterialById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
