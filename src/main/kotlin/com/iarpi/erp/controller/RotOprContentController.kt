package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateRotOprContentRequest
import com.iarpi.erp.controller.request.UpdateRotOprContentRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.RotOprContentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/rotopr/content")
data class RotOprContentController(val rotOprContentService: RotOprContentService) {
    @PostMapping
    fun createNewRotOprContent(@RequestBody request: CreateRotOprContentRequest): BaseResponse<*> {
        val data = rotOprContentService.createNewRotOprContent(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateRotOprContent(@PathVariable id: Long, @RequestBody request: UpdateRotOprContentRequest): BaseResponse<*> {
        val data = rotOprContentService.updateRotOprContent(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteRotOprContentById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotOprContentService.deleteRotOprContentById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllRotOprContent(): BaseResponse<*> {
        val data = rotOprContentService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getRotOprContentById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotOprContentService.getById(id)

        return BaseResponse.success(data)
    }
}
