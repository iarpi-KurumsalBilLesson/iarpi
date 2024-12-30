package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.LanguageDto
import com.iarpi.erp.model.entity.control.LanguageEntity

interface LanguageService {

    fun getAll(): List<LanguageDto>
    fun getByLanCode(lanCode: String): LanguageDto
    fun findById(id: Long): LanguageEntity

}
