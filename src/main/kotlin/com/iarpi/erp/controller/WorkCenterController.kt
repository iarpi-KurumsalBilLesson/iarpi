package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.request.CreateWorkCenterRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.WorkCenterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workcenter")
data class WorkCenterController(val workCenterService: WorkCenterService)
{
    @PostMapping
    fun createNewWorkCenter(@RequestBody request: CreateWorkCenterRequest): BaseResponse<*> {
        val data = workCenterService.createWorkCenter(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateWorkCenter(@PathVariable id: Long, @RequestBody request: UpdateWorkCenterRequest): BaseResponse<*> {
        val data = workCenterService.updateWorkCenter(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteWorkCenterById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterService.deleteWorkCenterById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllWorkCenter(): BaseResponse<*> {
        val data = workCenterService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getWorkCenterById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterService.getById(id)

        return BaseResponse.success(data)
    }
}
