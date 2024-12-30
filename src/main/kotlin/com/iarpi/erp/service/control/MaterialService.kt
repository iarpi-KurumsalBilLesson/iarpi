package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.MaterialControlDto
import com.iarpi.erp.model.entity.control.MaterialEntity

interface MaterialService {
    fun getAll(): List<MaterialControlDto>
    fun getById(id: Long): MaterialControlDto
    fun createNewMaterial(materialControlDto: MaterialControlDto): MaterialControlDto
    fun updateMaterial(id: Long, materialControlDto: MaterialControlDto): MaterialControlDto
    fun deleteMaterial(id: Long): String
    fun findById(id: Long) : MaterialEntity

}
