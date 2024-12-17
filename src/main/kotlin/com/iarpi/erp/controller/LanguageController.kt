package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateLanguageRequest
import com.iarpi.erp.controller.request.UpdateLanguageRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.LanguageDto
import com.iarpi.erp.service.LanguageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/language")
class LanguageController(val service: LanguageService) {

    @PostMapping
    fun createNewLanguage(@RequestBody request: CreateLanguageRequest): BaseResponse<LanguageDto> {
        val language = request.convertToDto()
        val response = service.createNewLanguage(language)
        return BaseResponse.success(response)
    }

    @PutMapping
    fun updateLanguage(@RequestBody request: UpdateLanguageRequest): BaseResponse<LanguageDto> {
        val language = request.convertToDto()
        val response = service.updateLanguage(language)

        return BaseResponse.success(response)
    }

    @DeleteMapping()
    fun deleteLanguage(@RequestBody language: LanguageDto): BaseResponse<String> {
        val response = service.deleteLanguage(language)

        return BaseResponse.success(response)
    }

    @GetMapping("/{comCode}")
    fun getByComCode(@PathVariable comCode: String): BaseResponse<LanguageDto> {
        val upperComCode = comCode.uppercase()
        val response = service.getByComCode(upperComCode)

        return BaseResponse.success(response)
    }

    @GetMapping("/{lanCode}")
    fun getByLanCode(@PathVariable lanCode: String): BaseResponse<LanguageDto> {
        val upperComCode = lanCode.uppercase()
        val response = service.getByLanCode(upperComCode)

        return BaseResponse.success(response)
    }

    @GetMapping()
    fun getAll(): BaseCollectionResponse<LanguageDto> {
        val response = service.getAll()

        return BaseCollectionResponse.success(response)
    }
}