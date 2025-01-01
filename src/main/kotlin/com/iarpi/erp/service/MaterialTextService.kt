package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateMaterialTextRequest
import com.iarpi.erp.controller.request.UpdateMaterialTextRequest

interface MaterialTextService {
    fun createNewMaterialText(request: CreateMaterialTextRequest)
    fun updateMaterialText(request: UpdateMaterialTextRequest)
    fun deleteMaterialTextById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}