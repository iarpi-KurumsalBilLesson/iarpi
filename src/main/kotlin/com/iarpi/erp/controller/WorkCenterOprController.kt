package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateWorkCenterOprRequest
import com.iarpi.erp.controller.request.UpdateWorkCenterOprRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.WorkCenterOprService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/workcenter/opr")
data class WorkCenterOprController(val workCenterOprService: WorkCenterOprService) {
    @PostMapping
    fun createNewWorkCenterOpr(@RequestBody request: CreateWorkCenterOprRequest): BaseResponse<*> {
        val data = workCenterOprService.createNewWorkCenterOpr(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateWorkCenterOpr(@PathVariable id: Long, @RequestBody request: UpdateWorkCenterOprRequest): BaseResponse<*> {
        val data = workCenterOprService.updateWorkCenterOpr(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteWorkCenterOprById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterOprService.deleteWorkCenterOprById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllWorkCenterOpr(): BaseResponse<*> {
        val data = workCenterOprService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getWorkCenterOprById(@PathVariable id: Long): BaseResponse<*> {
        val data = workCenterOprService.getById(id)

        return BaseResponse.success(data)
    }
}
