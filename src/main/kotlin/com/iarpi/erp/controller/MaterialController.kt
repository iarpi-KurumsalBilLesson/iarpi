package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateMaterialRequest
import com.iarpi.erp.controller.request.UpdateMaterialRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.MaterialService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material")
data class MaterialController(val materialService: MaterialService)
{
    @PostMapping
    fun createNewMaterial(@RequestBody request: CreateMaterialRequest): BaseResponse<*> {
        val data = materialService.createMaterial(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterial(@PathVariable id: Long, @RequestBody request: UpdateMaterialRequest): BaseResponse<*> {
        val data = materialService.updateMaterial(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteMaterialById(@PathVariable id: Long): BaseResponse<*> {
        val data = materialService.deleteMaterialById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllMaterial(): BaseResponse<*> {
        val data = materialService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getMaterialById(@PathVariable id: Long): BaseResponse<*> {
        val data = materialService.getById(id)

        return BaseResponse.success(data)
    }
}
