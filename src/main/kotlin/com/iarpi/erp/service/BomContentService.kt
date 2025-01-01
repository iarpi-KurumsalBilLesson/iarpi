package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateBomContentRequest
import com.iarpi.erp.controller.request.UpdateBomContentRequest


interface BomContentService {
    fun createNewBomContent(request: CreateBomContentRequest)
    fun updateBomContent(request: UpdateBomContentRequest)
    fun deleteBomContentById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}


