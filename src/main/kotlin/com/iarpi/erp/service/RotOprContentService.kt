package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateRotOprContentRequest
import com.iarpi.erp.controller.request.CreateRotOprContentRequest

interface RotOprContentService {
    fun createNewRotOprContent(request: CreateRotOprContentRequest)
    fun updateRotOprContent(request: UpdateRotOprContentRequest)
    fun deleteRotOprContentById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}