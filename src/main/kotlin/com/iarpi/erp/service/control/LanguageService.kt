package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateLanguageRequest
import com.iarpi.erp.controller.control.request.UpdateLanguageRequest


interface LanguageService {
    fun createLanguage(request: CreateLanguageRequest)
    fun updateLanguage(request: UpdateLanguageRequest)
    fun deleteLanguageById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
