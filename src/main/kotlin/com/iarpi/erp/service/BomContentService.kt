package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateBomContentRequest
import com.iarpi.erp.controller.request.CreateBomContentRequest


interface BomContentService {
    fun createNewBomContent(request: CreateBomContentRequest)
    fun updateBomContent(request: UpdateBomContentRequest)
    fun deleteBomContentById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}


