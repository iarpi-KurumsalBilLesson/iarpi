package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateLanguageRequest
import com.iarpi.erp.controller.control.request.UpdateLanguageRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.LanguageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/language")
data class LanguageController(val languageService: LanguageService)
{
    @PostMapping
    fun createNewLanguage(@RequestBody request: CreateLanguageRequest): BaseResponse<*> {
        val data = languageService.createLanguage(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateLanguage(@PathVariable id: Long, @RequestBody request: UpdateLanguageRequest): BaseResponse<*> {
        val data = languageService.updateLanguage(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteLanguageById(@PathVariable id: Long): BaseResponse<*> {
        val data = languageService.deleteLanguageById(id)

        return BaseResponse.success(data)
    }

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
