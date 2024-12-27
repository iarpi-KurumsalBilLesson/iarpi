package com.iarpi.erp.service

import com.iarpi.erp.model.dto.BomDto

interface BomService {
    fun getAll(): List<BomDto>
    fun getById(id: Long): BomDto
    fun createNewBom(bomDto: BomDto): BomDto
    fun updateBom(id: Long, bomDto: BomDto): BomDto
    fun deleteBom(id: Long): String

}
