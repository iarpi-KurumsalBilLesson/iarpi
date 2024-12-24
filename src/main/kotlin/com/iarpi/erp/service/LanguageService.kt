package com.iarpi.erp.service

import com.iarpi.erp.model.dto.LanguageDto

interface LanguageService {

    fun getAll(): List<LanguageDto>
    fun getByLanCode(lanCode: String): LanguageDto

}
