package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.model.dto.BomHeadDto

interface BomHeadService {
    fun createNewBomHead(request: CreateBomHeadRequest): BomHeadDto
    fun deleteBomHeadById(id: Long): String
    fun getAll(): List<BomHeadDto>
    fun getById(id: Long): BomHeadDto
    fun updateBomHead(id: Long, request: UpdateBomHeadRequest): BomHeadDto
    fun getAllBomContentByHeadId(bomHeadId: Long): List<BomContentDto>
}