package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateRotBomContentRequest
import com.iarpi.erp.controller.request.UpdateRotBomContentRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.MaterialTextService
import com.iarpi.erp.service.RotBomContentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rotbom/content")
data class RotBomContentController(val rotBomContentService: RotBomContentService) {

    @PostMapping
    fun createNewMaterialText(@RequestBody request: CreateRotBomContentRequest): BaseResponse<*> {
        val data = rotBomContentService.createNewRotBomContent(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterialText(@PathVariable id: Long, @RequestBody request: UpdateRotBomContentRequest): BaseResponse<*> {
        val data = rotBomContentService.updateRotBomContent(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteMaterialTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotBomContentService.deleteRotBomContentById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllMaterialText(): BaseResponse<*> {
        val data = rotBomContentService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getMaterialTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotBomContentService.getById(id)

        return BaseResponse.success(data)
    }
}