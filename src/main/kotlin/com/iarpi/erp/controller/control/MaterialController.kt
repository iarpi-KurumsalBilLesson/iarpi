package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateNewMaterialRequest
import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.controller.control.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.MaterialControlDto
import com.iarpi.erp.service.control.MaterialService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/control/material")
class MaterialController(val materialService: MaterialService) {

    @GetMapping()
    fun getMaterialCodes(): BaseResponse<List<MaterialControlDto>> {
        val data = materialService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getMaterialCodeById(@PathVariable id: Long): BaseResponse<MaterialControlDto> {
        val data = materialService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewMaterial(@RequestBody request: CreateNewMaterialRequest): BaseResponse<MaterialControlDto> {
        val data = materialService.createNewMaterial(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterial(@PathVariable id: Long, @RequestBody request: UpdateMaterialRequest): BaseResponse<MaterialControlDto> {
        val data = materialService.updateMaterial(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getMaterialCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = materialService.deleteMaterial(id)

        return BaseResponse.success(data);
    }
}