package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.BomDto
import com.iarpi.erp.model.entity.control.BomEntity

interface BomService {
    fun getAll(): List<BomDto>
    fun getById(id: Long): BomDto
    fun createNewBom(bomDto: BomDto): BomDto
    fun updateBom(id: Long, bomDto: BomDto): BomDto
    fun deleteBom(id: Long): String
    fun findById(id: Long): BomEntity

}
