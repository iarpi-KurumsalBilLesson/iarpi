package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateOperationRequest
import com.iarpi.erp.controller.request.UpdateOperationRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.OperationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operation")
data class OperationController(val operationService: OperationService)
{
    @PostMapping
    fun createNewOperation(@RequestBody request: CreateOperationRequest): BaseResponse<*> {
        val data = operationService.createOperation(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateOperation(@PathVariable id: Long, @RequestBody request: UpdateOperationRequest): BaseResponse<*> {
        val data = operationService.updateOperation(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteOperationById(@PathVariable id: Long): BaseResponse<*> {
        val data = operationService.deleteOperationById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllOperation(): BaseResponse<*> {
        val data = operationService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getOperationById(@PathVariable id: Long): BaseResponse<*> {
        val data = operationService.getById(id)

        return BaseResponse.success(data)
    }
}
