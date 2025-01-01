package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateBomRequest
import com.iarpi.erp.controller.control.request.UpdateBomRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.BomService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bom")
data class BomController(val bomService: BomService)
{
    @PostMapping
    fun createNewBom(@RequestBody request: CreateBomRequest): BaseResponse<*> {
        val data = bomService.createBom(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateBom(@PathVariable id: Long, @RequestBody request: UpdateBomRequest): BaseResponse<*> {
        val data = bomService.updateBom(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteBomById(@PathVariable id: Long): BaseResponse<*> {
        val data = bomService.deleteBomById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllBom(): BaseResponse<*> {
        val data = bomService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getBomById(@PathVariable id: Long): BaseResponse<*> {
        val data = bomService.getById(id)

        return BaseResponse.success(data)
    }
}
