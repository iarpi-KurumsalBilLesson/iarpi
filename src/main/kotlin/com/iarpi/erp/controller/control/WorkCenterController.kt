package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateNewWorkCenterRequest
import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.control.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.WorkCenterDto
import com.iarpi.erp.service.control.WorkCenterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/work-center")
class WorkCenterController(val workCenterService: WorkCenterService) {
    @GetMapping()
    fun getWorkCenterCodes(): BaseResponse<List<WorkCenterDto>> {
        val data = workCenterService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getWorkCenterCodeById(@PathVariable id: Long): BaseResponse<WorkCenterDto> {
        val data = workCenterService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewWorkCenter(@RequestBody request: CreateNewWorkCenterRequest): BaseResponse<WorkCenterDto> {
        val data = workCenterService.createNewWorkCenter(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateWorkCenter(
        @PathVariable id: Long,
        @RequestBody request: UpdateWorkCenterRequest
    ): BaseResponse<WorkCenterDto> {
        val data = workCenterService.updateWorkCenter(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getWorkCenterCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = workCenterService.deleteWorkCenter(id)

        return BaseResponse.success(data);
    }
}