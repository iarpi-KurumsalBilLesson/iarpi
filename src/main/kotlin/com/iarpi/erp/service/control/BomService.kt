package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateBomRequest
import com.iarpi.erp.controller.control.request.CreateBomRequest


interface BomService {
    fun createBom(request: CreateBomRequest)
    fun updateBom(request: UpdateBomRequest)
    fun deleteBomById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
