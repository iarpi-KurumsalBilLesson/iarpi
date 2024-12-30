package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.model.dto.MaterialTextDto

interface MaterialTextService {
    fun getById(id: Long): MaterialTextDto
    fun updateMaterialHead(id: Long, request: UpdateMaterialTextRequest): MaterialTextDto
    fun deleteById(id: Long): String
    fun getByHeadId(headId: Long): MaterialTextDto


}
