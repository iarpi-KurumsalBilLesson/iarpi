package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.controller.request.CreateBomHeadRequest

interface BomHeadService {
    fun createNewBomHead(request: CreateBomHeadRequest)
    fun updateBomHead(request: UpdateBomHeadRequest)
    fun deleteBomHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}