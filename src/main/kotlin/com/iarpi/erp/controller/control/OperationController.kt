package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateOperationRequest
import com.iarpi.erp.controller.control.request.UpdateOperationRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.OperationDto
import com.iarpi.erp.service.control.OperationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operation")
class OperationController(val operationService: OperationService) {

    @PostMapping
    fun createNewOperation(@RequestBody request: CreateOperationRequest): BaseResponse<OperationDto> {
        val data = operationService.createOperation(request)
        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateOperation(
        @PathVariable id: Long,
        @RequestBody request: UpdateOperationRequest
    ): BaseResponse<OperationDto> {
        val data = operationService.updateOperation(id, request)
        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun deleteOperationById(@PathVariable id: Long): BaseResponse<String> {
        val data = operationService.deleteOperationById(id)
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllOperation(): BaseResponse<List<OperationDto>> {
        val data = operationService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getOperationById(@PathVariable id: Long): BaseResponse<OperationDto> {
        val data = operationService.getById(id)
        return BaseResponse.success(data)
    }
}
