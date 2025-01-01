package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.LanguageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/language")
data class LanguageController(val languageService: LanguageService) {


    @GetMapping
    fun getAllLanguage(): BaseResponse<*> {
        val data = languageService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getLanguageById(@PathVariable id: Long): BaseResponse<*> {
        val data = languageService.getById(id)

        return BaseResponse.success(data)
    }
}
