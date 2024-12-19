package com.iarpi.erp.controller

import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.LanguageDto
import com.iarpi.erp.service.LanguageService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/language")
class LanguageController(val service: LanguageService) {

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