package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.service.MaterialHeadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material")
class MaterialHeadController(val materialHeadService: MaterialHeadService) {

    @GetMapping
    fun getAll() : BaseResponse<List<MaterialDto>> {
        val data = materialHeadService.getAll();
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id : Long) : BaseResponse<MaterialDto> {
        val data = materialHeadService.getById(id);
        return BaseResponse.success(data)
    }

    @PostMapping
    fun createNewMaterialHead(@RequestBody request: CreateNewMaterialHeadRequest): BaseResponse<MaterialDto> {
        return BaseResponse.success(materialHeadService.createNewHeadMaterial(request));
    }

    @PutMapping("/{id}")
    fun updateMaterialHead(@PathVariable id : Long,@RequestBody request: UpdateMaterialHeadRequest): BaseResponse<MaterialDto> {
        return BaseResponse.success(materialHeadService.updateMaterialHead(id,request))
    }

    @DeleteMapping("/{id}")
    fun deleteMaterialHead(@PathVariable id: Long): BaseResponse<String> {
        val data = materialHeadService.deleteById(id);
        return BaseResponse.success(data)
    }
}