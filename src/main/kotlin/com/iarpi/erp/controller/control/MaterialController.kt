package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateMaterialRequest
import com.iarpi.erp.controller.control.request.UpdateMaterialRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.MaterialDto
import com.iarpi.erp.service.control.MaterialService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material")
class MaterialController(val materialService: MaterialService) {

    @PostMapping
    fun createNewMaterial(@RequestBody request: CreateMaterialRequest): BaseResponse<MaterialDto> {
        val data = materialService.createMaterial(request)
        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateMaterial(@PathVariable id: Long, @RequestBody request: UpdateMaterialRequest): BaseResponse<MaterialDto> {
        val data = materialService.updateMaterial(id, request)
        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun deleteMaterialById(@PathVariable id: Long): BaseResponse<String> {
        val data = materialService.deleteMaterialById(id)
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllMaterial(): BaseResponse<List<MaterialDto>> {
        val data = materialService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getMaterialById(@PathVariable id: Long): BaseResponse<MaterialDto> {
        val data = materialService.getById(id)
        return BaseResponse.success(data)
    }
}
