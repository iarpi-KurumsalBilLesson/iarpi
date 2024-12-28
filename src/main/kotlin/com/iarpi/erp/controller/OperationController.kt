package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewOperationRequest
import com.iarpi.erp.controller.request.UpdateOperationRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.OperationDto
import com.iarpi.erp.service.OperationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/operation")
class OperationController(val operationService: OperationService) {
    @GetMapping()
    fun getOperationCodes(): BaseResponse<List<OperationDto>> {
        val data = operationService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getOperationCodeById(@PathVariable id: Long): BaseResponse<OperationDto> {
        val data = operationService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewOperation(@RequestBody request: CreateNewOperationRequest): BaseResponse<OperationDto> {
        val data = operationService.createNewOperation(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateOperation(@PathVariable id: Long, @RequestBody request: UpdateOperationRequest): BaseResponse<OperationDto> {
        val data = operationService.updateOperation(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getOperationCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = operationService.deleteOperation(id)

        return BaseResponse.success(data);
    }
}