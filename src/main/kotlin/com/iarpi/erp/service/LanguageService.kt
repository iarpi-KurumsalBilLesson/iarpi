package com.iarpi.erp.service

import com.iarpi.erp.model.dto.control.LanguageDto
import com.iarpi.erp.model.entity.LanguageEntity

interface LanguageService {

    fun getAll(): List<LanguageDto>
    fun getByLanCode(lanCode: String): LanguageDto
    fun findById(id: Long): LanguageEntity

}
