package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCostCenterTextRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterTextRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.CostCenterTextService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/costcenter/text")
data class CostCenterTextController(val costCenterTextService: CostCenterTextService) {
    @PostMapping
    fun createNewCostCenterHead(@RequestBody request: CreateCostCenterTextRequest): BaseResponse<*> {
        val data = costCenterTextService.createNewCostCenterText(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCostCenterHead(@PathVariable id: Long, @RequestBody request: UpdateCostCenterTextRequest): BaseResponse<*> {
        val data = costCenterTextService.updateCostCenterText(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteCostCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterTextService.deleteCostCenterTextById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllCostCenterHead(): BaseResponse<*> {
        val data = costCenterTextService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getCostCenterHeadById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterTextService.getById(id)

        return BaseResponse.success(data)
    }
}
