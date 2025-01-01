package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateWorkCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.WorkCenterHeadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workcenter/head")
data class WorkCenterHeadController(val workCenterHeadService: WorkCenterHeadService)
{
    @PostMapping
    fun createNewWorkCenterHead(@RequestBody request: CreateWorkCenterHeadRequest): BaseResponse<*> {
        val data = workCenterHeadService.createNewWorkCenterHead(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateWorkCenterHead(@PathVariable id: Long, @RequestBody request: UpdateWorkCenterHeadRequest): BaseResponse<*> {
        val data = workCenterHeadService.updateWorkCenterHead(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteWorkCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterHeadService.deleteWorkCenterHeadById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllWorkCenterHead(): BaseResponse<*> {
        val data = workCenterHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getWorkCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterHeadService.getById(id)

        return BaseResponse.success(data)
    }
}
