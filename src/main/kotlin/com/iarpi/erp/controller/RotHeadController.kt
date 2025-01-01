package com.iarpi.erp.controller


import com.iarpi.erp.controller.request.CreateRotHeadRequest
import com.iarpi.erp.controller.request.UpdateRotHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.RotHeadService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/rot/head")
data class RotHeadController(val rotHeadService: RotHeadService)
{
    @PostMapping
    fun createNewRotHead(@RequestBody request: CreateRotHeadRequest): BaseResponse<*> {
        val data = rotHeadService.createNewRotHead(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateRotHead(@PathVariable id: Long, @RequestBody request: UpdateRotHeadRequest): BaseResponse<*> {
        val data = rotHeadService.updateRotHead(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteRotHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotHeadService.deleteRotHeadById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllRotHead(): BaseResponse<*> {
        val data = rotHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getRotHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = rotHeadService.getById(id)

        return BaseResponse.success(data)
    }
}
