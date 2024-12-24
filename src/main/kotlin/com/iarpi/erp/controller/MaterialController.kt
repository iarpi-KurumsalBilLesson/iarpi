package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewMaterialRequest
import com.iarpi.erp.controller.request.UpdateMaterialRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.service.MaterialService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material")
class MaterialController(val materialService: MaterialService) {

    @GetMapping()
    fun getMaterialCodes(): BaseResponse<List<MaterialDto>> {
        val data = materialService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getMaterialCodeById(@PathVariable id: Long): BaseResponse<MaterialDto> {
        val data = materialService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewMaterial(@RequestBody request: CreateNewMaterialRequest): BaseResponse<MaterialDto> {
        val data = materialService.createNewMaterial(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterial(@PathVariable id: Long, @RequestBody request: UpdateMaterialRequest): BaseResponse<MaterialDto> {
        val data = materialService.updateMaterial(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getMaterialCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = materialService.deleteMaterial(id)

        return BaseResponse.success(data);
    }
}