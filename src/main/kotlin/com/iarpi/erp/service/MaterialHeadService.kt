package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest

interface MaterialHeadService {

    fun createNewMaterialHead(request: CreateMaterialHeadRequest)
    fun updateMaterialHead(request: UpdateMaterialHeadRequest)
    fun deleteMaterialHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
