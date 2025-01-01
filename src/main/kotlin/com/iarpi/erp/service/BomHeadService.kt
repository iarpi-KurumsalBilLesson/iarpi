package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest

interface BomHeadService {
    fun createNewBomHead(request: CreateBomHeadRequest)
    fun updateBomHead(request: UpdateBomHeadRequest)
    fun deleteBomHeadById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}