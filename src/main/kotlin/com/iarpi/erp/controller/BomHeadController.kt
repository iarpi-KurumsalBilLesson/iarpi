package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.model.dto.BomHeadDto
import com.iarpi.erp.service.BomHeadService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/bom/head")
data class BomHeadController(val bomHeadService: BomHeadService) {

    //todo : kullanılacak mı ?
    @PostMapping
    fun createNewBomHead(@Valid @RequestBody request: CreateBomHeadRequest): BaseResponse<*> {
        val data = bomHeadService.createNewBomHead(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateBomHead(@PathVariable id: Long, @Valid @RequestBody request: UpdateBomHeadRequest): BaseResponse<BomHeadDto> {
        val data = bomHeadService.updateBomHead(id, request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteBomHeadById(@PathVariable id: Long): BaseResponse<String> {
        val data = bomHeadService.deleteBomHeadById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllBomHead(): BaseResponse<List<BomHeadDto>> {
        val data = bomHeadService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getBomHeadById(@PathVariable id: Long): BaseResponse<BomHeadDto> {
        val data = bomHeadService.getById(id)

        return BaseResponse.success(data)
    }

    @GetMapping("/contents/{id}")
    fun getAllBomContentByBomHeadId(@PathVariable id : Long): BaseResponse<List<BomContentDto>> {
        val data = bomHeadService.getAllBomContentByHeadId(id)
        return BaseResponse.success(data)
    }
}
