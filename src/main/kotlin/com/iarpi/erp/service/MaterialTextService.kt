package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.controller.request.CreateMaterialTextRequest

interface MaterialTextService {
    fun createNewMaterialText(request: CreateMaterialTextRequest)
    fun updateMaterialText(request: UpdateMaterialTextRequest)
    fun deleteMaterialTextById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}