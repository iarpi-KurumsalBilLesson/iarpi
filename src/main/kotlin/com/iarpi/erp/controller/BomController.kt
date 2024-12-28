package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.*
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.BomDto
import com.iarpi.erp.service.BomService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bom")
class BomController(val bomService: BomService) {
    @GetMapping()
    fun getbomCodes(): BaseResponse<List<BomDto>> {
        val data = bomService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getbomCodeById(@PathVariable id: Long): BaseResponse<BomDto> {
        val data = bomService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewbom(@RequestBody request: CreateNewBomRequest): BaseResponse<BomDto> {
        val data = bomService.createNewBom(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updatebom(@PathVariable id: Long, @RequestBody request: UpdateBomRequest): BaseResponse<BomDto> {
        val data = bomService.updateBom(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getbomCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = bomService.deleteBom(id)

        return BaseResponse.success(data);
    }
}