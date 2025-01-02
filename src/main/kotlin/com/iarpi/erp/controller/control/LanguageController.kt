package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.LanguageDto
import com.iarpi.erp.service.control.LanguageService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/languages")
class LanguageController(
    private val languageService: LanguageService
) {
    @GetMapping
    fun getAllLanguage(): BaseResponse<List<LanguageDto>> {
        val languages = languageService.getAll()
        return BaseResponse.success(languages)
    }

    @GetMapping("/{id}")
    fun getLanguageById(@PathVariable id: Long): BaseResponse<LanguageDto> {
        val language = languageService.getById(id)
        return BaseResponse.success(language)
    }
}
