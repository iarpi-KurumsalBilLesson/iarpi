package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateMaterialTextRequest
import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.MaterialTextService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material/text")
class MaterialTextController(val materialTextService: MaterialTextService) {

    @PostMapping
    fun createNewMaterialText(@RequestBody request: CreateMaterialTextRequest): BaseResponse<*> {
        val data = materialTextService.createNewMaterialText(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterialText(@PathVariable id: Long, @RequestBody request: UpdateMaterialTextRequest): BaseResponse<*> {
        val data = materialTextService.updateMaterialText(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteMaterialTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = materialTextService.deleteMaterialTextById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllMaterialText(): BaseResponse<*> {
        val data = materialTextService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getMaterialTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = materialTextService.getById(id)

        return BaseResponse.success(data)
    }
}