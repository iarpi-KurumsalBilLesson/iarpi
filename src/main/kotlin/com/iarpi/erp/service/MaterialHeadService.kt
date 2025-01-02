package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.model.dto.MaterialHeadDto

interface MaterialHeadService {

    fun createNewMaterialHead(request: CreateMaterialHeadRequest): MaterialHeadDto
    fun updateMaterialHead(id : Long,request: UpdateMaterialHeadRequest): MaterialHeadDto
    fun deleteMaterialHeadById(id: Long): String
    fun getAll(): List<MaterialHeadDto>
    fun getById(id: Long): MaterialHeadDto
}
