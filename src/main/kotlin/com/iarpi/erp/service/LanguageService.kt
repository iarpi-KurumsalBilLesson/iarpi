package com.iarpi.erp.service

import com.iarpi.erp.model.dto.LanguageDto

interface LanguageService {

    fun createNewLanguage(language: LanguageDto): LanguageDto
    fun updateLanguage(language: LanguageDto): LanguageDto
    fun deleteLanguage(language: LanguageDto): String
    fun getAll(): List<LanguageDto>
    fun getByLanCode(lanCode: String): LanguageDto
    fun getByComCode(comCode: String): LanguageDto

}
