package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.request.CreateCostCenterRequest
import com.iarpi.erp.controller.control.request.UpdateCostCenterRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.CostCenterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/costcenter")
data class CostCenterController(val costCenterService: CostCenterService,)
{
    @PostMapping
    fun createNewCostCenter(@RequestBody request: CreateCostCenterRequest): BaseResponse<*> {
        val data = costCenterService.createCostCenter(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCostCenter(@PathVariable id: Long, @RequestBody request: UpdateCostCenterRequest): BaseResponse<*> {
        val data = costCenterService.updateCostCenter(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteCostCenterById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterService.deleteCostCenterById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllCostCenter(): BaseResponse<*> {
        val data = costCenterService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getCostCenterById(@PathVariable id: Long): BaseResponse<*> {
        val data = costCenterService.getById(id)

        return BaseResponse.success(data)
    }
}
