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
    fun getDetailById(@PathVariable id : Long) : BaseResponse<MaterialDto> {
        val data = materialHeadService.getDetailById(id);
        return BaseResponse.success(data)
    }

    @PostMapping
    fun createNewMaterial(@RequestBody request: CreateNewMaterialHeadRequest): BaseResponse<MaterialDto> {
        return BaseResponse.success(materialHeadService.createNewHeadMaterial(request));
    }

    @PutMapping("/{id}")
    fun updateMaterial(@PathVariable id : Long,@RequestBody request: UpdateMaterialHeadRequest): BaseResponse<MaterialDto> {
        return BaseResponse.success(materialHeadService.updateMaterialHead(id,request))
    }

    @DeleteMapping("/{id}")
    fun deleteMaterial(@PathVariable id: Long): BaseResponse<String> {
        val data = materialHeadService.deleteById(id);
        return BaseResponse.success(data)
    }
}