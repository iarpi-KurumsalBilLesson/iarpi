package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateBomRequest
import com.iarpi.erp.controller.request.CreateBomRequest


interface BomService {
    fun createBom(request: CreateBomRequest)
    fun updateBom(request: UpdateBomRequest)
    fun deleteBomById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
