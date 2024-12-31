package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.BomHeadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bom/head")
data class BomHeadController(val bomHeadService : BomHeadService)
{
    @PostMapping
    fun createNewBomHead(@RequestBody request: CreateBomHeadRequest): BaseResponse<*> {
        val data = bomHeadService.createNewBomHead(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateBomHead(@PathVariable id: Long, @RequestBody request: UpdateBomHeadRequest): BaseResponse<*> {
        val data = bomHeadService.updateBomHead(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteBomHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = bomHeadService.deleteBomHeadById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllBomHead(): BaseResponse<*> {
        val data = bomHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getBomHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = bomHeadService.getById(id)

        return BaseResponse.success(data)
    }
}
