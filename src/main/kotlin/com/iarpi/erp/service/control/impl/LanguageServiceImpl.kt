package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateLanguageRequest
import com.iarpi.erp.controller.control.request.UpdateLanguageRequest
import com.iarpi.erp.repository.control.LanguageRepository
import com.iarpi.erp.service.control.LanguageService
import org.springframework.stereotype.Service

@Service
data class LanguageServiceImpl(val languageRepository: LanguageRepository) : LanguageService {


    override fun createLanguage(request: CreateLanguageRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateLanguage(request: UpdateLanguageRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteLanguageById(id: Long): String {
        TODO("Not yet implemented")
    }

}
