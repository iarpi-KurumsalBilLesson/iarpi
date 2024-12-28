package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.model.dto.MaterialTextDto
import com.iarpi.erp.service.MaterialHeadService
import com.iarpi.erp.service.MaterialTextService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/material/text")
class MaterialTextController(val materialTextService: MaterialTextService) {

    //todo: gerek var mı ?
    /*@GetMapping
    fun getAll() : BaseResponse<List<MaterialDto>> {
        val data = materialHeadService.getAll();
        return BaseResponse.success(data)
    }*/

    @GetMapping("/{id}")
    fun getDetailById(@PathVariable id : Long) : BaseResponse<MaterialTextDto> {
        val data = materialTextService.getById(id);
        return BaseResponse.success(data)
    }

    //todo: gerek var mı ?
    /*@PostMapping
    fun createNewMaterial(@RequestBody request: CreateNewMaterialHeadRequest): BaseResponse<MaterialDto> {
        return BaseResponse.success(materialHeadService.createNewHeadMaterial(request));
    }*/

    @PutMapping("/{id}")
    fun updateMaterialText(@PathVariable id : Long,@RequestBody request: UpdateMaterialTextRequest): BaseResponse<MaterialTextDto> {
        return BaseResponse.success(materialTextService.updateMaterialHead(id,request))
    }

    @DeleteMapping("/{id}")
    fun deleteMaterial(@PathVariable id: Long): BaseResponse<String> {
        val data = materialTextService.deleteById(id);
        return BaseResponse.success(data)
    }
}