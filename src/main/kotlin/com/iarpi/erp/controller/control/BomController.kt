package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateNewBomRequest
import com.iarpi.erp.controller.control.request.UpdateBomRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.BomDto
import com.iarpi.erp.service.control.BomService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bom")
class BomController(val bomService: BomService) {

    @PostMapping
    fun createNewBom(@RequestBody request: CreateNewBomRequest): BaseResponse<BomDto> {
        val data = bomService.createBom(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateBom(@PathVariable id: Long, @RequestBody request: UpdateBomRequest): BaseResponse<BomDto> {
        val data = bomService.updateBom(id, request)

        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteBomById(@PathVariable id: Long): BaseResponse<String> {
        val data = bomService.deleteBomById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllBom(): BaseResponse<List<BomDto>> {
        val data = bomService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getBomById(@PathVariable id: Long): BaseResponse<BomDto> {
        val data = bomService.getById(id)

        return BaseResponse.success(data)
    }
}
