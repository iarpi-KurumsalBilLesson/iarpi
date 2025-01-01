package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.UpdateUnitRequest
import com.iarpi.erp.controller.control.request.CreateUnitRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.UnitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/unit")
data class UnitController(val unitService: UnitService)
{
    @PostMapping
    fun createNewUnit(@RequestBody request: CreateUnitRequest): BaseResponse<*> {
        val data = unitService.createUnit(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateUnit(@PathVariable id: Long, @RequestBody request: UpdateUnitRequest): BaseResponse<*> {
        val data = unitService.updateUnit(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteUnitById(@PathVariable id: Long): BaseResponse<*> {
        val data = unitService.deleteUnitById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllUnit(): BaseResponse<*> {
        val data = unitService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getUnitById(@PathVariable id: Long): BaseResponse<*> {
        val data = unitService.getById(id)

        return BaseResponse.success(data)
    }
}
