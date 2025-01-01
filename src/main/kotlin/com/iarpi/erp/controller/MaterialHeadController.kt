package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.MaterialHeadDto
import com.iarpi.erp.service.MaterialHeadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material/head")
class MaterialHeadController(val materialHeadService : MaterialHeadService) {

    @PostMapping
    fun createNewMaterialHead(@RequestBody request: CreateMaterialHeadRequest): BaseResponse<MaterialHeadDto> {
        val data = materialHeadService.createNewMaterialHead(request)
        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterialHead(@PathVariable id: Long, @RequestBody request: UpdateMaterialHeadRequest): BaseResponse<MaterialHeadDto> {
        val data = materialHeadService.updateMaterialHead(request)
        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun deleteMaterialHeadById(@PathVariable id: Long): BaseResponse<String> {
        val data = materialHeadService.deleteMaterialHeadById(id)
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllMaterialHead(): BaseResponse<List<MaterialHeadDto>> {
        val data = materialHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getMaterialHeadById(@PathVariable id: Long): BaseResponse<MaterialHeadDto> {
        val data = materialHeadService.getById(id)
        return BaseResponse.success(data)
    }
}