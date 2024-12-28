package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewUnitRequest
import com.iarpi.erp.controller.request.UpdateUnitRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.UnitDto
import com.iarpi.erp.service.UnitService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/unit")
class UnitController(val unitService: UnitService) {

    @GetMapping()
    fun getUnitCodes(): BaseResponse<List<UnitDto>> {
        val units = unitService.getAll()

        return BaseResponse.success(units);
    }

    @GetMapping("/{id}")
    fun getUnitCodeById(@PathVariable id: Long): BaseResponse<UnitDto> {
        val units = unitService.getById(id)

        return BaseResponse.success(units);
    }

    @PostMapping
    fun createNewUnit(@RequestBody request: CreateNewUnitRequest): BaseResponse<UnitDto> {
        val record = unitService.createNewUnit(request.convertToDto())

        return BaseResponse.success(record)
    }

    @PutMapping("/{id}")
    fun updateUnit(@PathVariable id: Long, @RequestBody request: UpdateUnitRequest): BaseResponse<UnitDto> {
        val record = unitService.updateUnit(id, request.convertToDto())

        return BaseResponse.success(record)
    }

    @DeleteMapping("/{id}")
    fun getUnitCodes(@PathVariable id: Long): BaseResponse<String> {
        val units = unitService.deleteUnit(id)

        return BaseResponse.success(units);
    }
}