package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateUnitRequest
import com.iarpi.erp.controller.control.request.UpdateUnitRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.UnitDto
import com.iarpi.erp.service.control.UnitService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/units")
class UnitController(
    private val unitService: UnitService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewUnit(@Valid @RequestBody request: CreateUnitRequest): BaseResponse<UnitDto> {
        val unit = unitService.createUnit(request)
        return BaseResponse.success(unit)
    }

    @PutMapping("/{id}")
    fun updateUnit(@PathVariable id: Long, @Valid @RequestBody request: UpdateUnitRequest): BaseResponse<UnitDto> {
        val unit = unitService.updateUnit(id, request)
        return BaseResponse.success(unit)
    }

    @DeleteMapping("/{id}")
    fun deleteUnitById(@PathVariable id: Long): BaseResponse<String> {
        val result = unitService.deleteUnitById(id)
        return BaseResponse.success(result)
    }

    @GetMapping
    fun getAllUnit(): BaseResponse<List<UnitDto>> {
        val units = unitService.getAll()
        return BaseResponse.success(units)
    }

    @GetMapping("/{id}")
    fun getUnitById(@PathVariable id: Long): BaseResponse<UnitDto> {
        val unit = unitService.getById(id)
        return BaseResponse.success(unit)
    }
}
