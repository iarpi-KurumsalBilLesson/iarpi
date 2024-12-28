package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewCostCenterRequest
import com.iarpi.erp.controller.request.UpdateCostCenterRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CostCenterDto
import com.iarpi.erp.service.CostCenterService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cost-center")
class CostCenterController(val costCenterService: CostCenterService) {

    @GetMapping()
    fun getCostCenterCodes(): BaseResponse<List<CostCenterDto>> {
        val data = costCenterService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getCostCenterCodeById(@PathVariable id: Long): BaseResponse<CostCenterDto> {
        val data = costCenterService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewCostCenter(@RequestBody request: CreateNewCostCenterRequest): BaseResponse<CostCenterDto> {
        val data = costCenterService.createNewCostCenter(request.convertToDto())

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCostCenter(@PathVariable id: Long, @RequestBody request: UpdateCostCenterRequest): BaseResponse<CostCenterDto> {
        val data = costCenterService.updateCostCenter(id, request.convertToDto())

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun getCostCenterCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = costCenterService.deleteCostCenter(id)

        return BaseResponse.success(data);
    }
}