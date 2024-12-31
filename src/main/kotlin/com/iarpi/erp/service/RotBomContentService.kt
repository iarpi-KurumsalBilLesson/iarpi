package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateRotBomContentRequest
import com.iarpi.erp.controller.request.CreateRotBomContentRequest

interface RotBomContentService {
    fun createNewRotBomContent(request: CreateRotBomContentRequest)
    fun updateRotBomContent(request: UpdateRotBomContentRequest)
    fun deleteRotBomContentById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}