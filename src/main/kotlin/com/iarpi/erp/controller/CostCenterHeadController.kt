package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.CostCenterHeadService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/costCenter/head")
data class CostCenterHeadController(val costCenterHeadService: CostCenterHeadService) {
    @PostMapping
    fun createNewCostCenterHead(@RequestBody request: CreateCostCenterHeadRequest): BaseResponse<*> {
        val data = costCenterHeadService.createNewCostCenterHead(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCostCenterHead(
        @PathVariable id: Long,
        @RequestBody request: UpdateCostCenterHeadRequest
    ): BaseResponse<*> {
        val data = costCenterHeadService.updateCostCenterHead(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteCostCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterHeadService.deleteCostCenterHeadById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllCostCenterHead(): BaseResponse<*> {
        val data = costCenterHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getCostCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterHeadService.getById(id)

        return BaseResponse.success(data)
    }
}
