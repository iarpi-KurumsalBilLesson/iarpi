package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateNewMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.model.dto.MaterialDto


interface MaterialHeadService {

    fun createNewHeadMaterial(request: CreateNewMaterialHeadRequest): MaterialDto
    fun updateMaterialHead(id: Long, request: UpdateMaterialHeadRequest): MaterialDto
    fun deleteById(id: Long): String
    fun getAll(): List<MaterialDto>
    fun getById(id: Long): MaterialDto

}
