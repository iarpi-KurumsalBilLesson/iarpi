package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateRotHeadRequest
import com.iarpi.erp.controller.request.CreateRotHeadRequest

interface RotHeadService {
    fun createNewRotHead(request: CreateRotHeadRequest)
    fun updateRotHead(request: UpdateRotHeadRequest)
    fun deleteRotHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}