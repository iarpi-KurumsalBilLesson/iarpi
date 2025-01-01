package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateWorkCenterTextRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterTextRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.WorkCenterTextService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workcenter/text")
data class WorkCenterTextController(val workCenterTextService: WorkCenterTextService) {
    @PostMapping
    fun createNewWorkCenterText(@RequestBody request: CreateWorkCenterTextRequest): BaseResponse<*> {
        val data = workCenterTextService.createNewWorkCenterText(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateWorkCenterText(
        @PathVariable id: Long,
        @RequestBody request: UpdateWorkCenterTextRequest
    ): BaseResponse<*> {
        val data = workCenterTextService.updateWorkCenterText(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteWorkCenterTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterTextService.deleteWorkCenterTextById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllWorkCenterText(): BaseResponse<*> {
        val data = workCenterTextService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getWorkCenterTextById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterTextService.getById(id)

        return BaseResponse.success(data)
    }
}
