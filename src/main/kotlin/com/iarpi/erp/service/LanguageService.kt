package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateLanguageRequest
import com.iarpi.erp.controller.request.CreateLanguageRequest


interface LanguageService {
    fun createLanguage(request: CreateLanguageRequest)
    fun updateLanguage(request: UpdateLanguageRequest)
    fun deleteLanguageById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
