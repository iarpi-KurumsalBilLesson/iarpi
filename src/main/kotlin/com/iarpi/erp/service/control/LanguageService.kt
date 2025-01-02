package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.LanguageDto

interface LanguageService {
    fun getAll(): List<LanguageDto>
    fun getById(id: Long): LanguageDto
}
