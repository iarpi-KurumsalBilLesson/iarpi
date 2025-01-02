package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateBomContentRequest
import com.iarpi.erp.controller.request.UpdateBomContentRequest
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.model.entity.BomContentEntity


interface BomContentService {
    fun createNewBomContent(request: CreateBomContentRequest): BomContentDto
    fun updateBomContent(request: UpdateBomContentRequest): BomContentDto
    fun deleteBomContentById(id: Long): String
    fun getAll(): List<BomContentDto>
    fun getById(id: Long): BomContentDto
}


