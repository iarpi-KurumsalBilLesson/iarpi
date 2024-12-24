package com.iarpi.erp.service

import com.iarpi.erp.model.dto.MaterialDto

interface MaterialService {
    fun getAll(): List<MaterialDto>
    fun getById(id: Long): MaterialDto
    fun createNewMaterial(materialDto: MaterialDto): MaterialDto
    fun updateMaterial(id: Long, materialDto: MaterialDto): MaterialDto
    fun deleteMaterial(id: Long): String

}
