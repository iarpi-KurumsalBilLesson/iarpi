package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateWorkCenterRequest
import com.iarpi.erp.controller.control.request.UpdateWorkCenterRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.WorkCenterDto
import com.iarpi.erp.service.control.WorkCenterService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/work-centers")
class WorkCenterController(
    private val workCenterService: WorkCenterService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewWorkCenter(@Valid @RequestBody request: CreateWorkCenterRequest): BaseResponse<WorkCenterDto> {
        val workCenter = workCenterService.createWorkCenter(request)
        return BaseResponse.success(workCenter)
    }

    @PutMapping("/{id}")
    fun updateWorkCenter(
        @PathVariable id: Long,
        @Valid @RequestBody request: UpdateWorkCenterRequest
    ): BaseResponse<WorkCenterDto> {
        val workCenter = workCenterService.updateWorkCenter(id, request)
        return BaseResponse.success(workCenter)
    }

    @DeleteMapping("/{id}")
    fun deleteWorkCenterById(@PathVariable id: Long): BaseResponse<String> {
        val result = workCenterService.deleteWorkCenterById(id)
        return BaseResponse.success(result)
    }

    @GetMapping
    fun getAllWorkCenter(): BaseResponse<List<WorkCenterDto>> {
        val workCenters = workCenterService.getAll()
        return BaseResponse.success(workCenters)
    }

    @GetMapping("/{id}")
    fun getWorkCenterById(@PathVariable id: Long): BaseResponse<WorkCenterDto> {
        val workCenter = workCenterService.getById(id)
        return BaseResponse.success(workCenter)
    }
}
