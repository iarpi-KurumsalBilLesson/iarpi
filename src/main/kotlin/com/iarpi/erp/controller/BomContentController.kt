package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateBomContentRequest
import com.iarpi.erp.controller.request.UpdateBomContentRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.service.BomContentService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/bom/content")
class BomContentController(val bomContentService: BomContentService) {

    @PostMapping
    fun createNewBomContent(@Valid @RequestBody request: CreateBomContentRequest): BaseResponse<BomContentDto> {
        val data = bomContentService.createNewBomContent(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateBomContent(@PathVariable id: Long, @RequestBody request: UpdateBomContentRequest): BaseResponse<BomContentDto> {
        val data = bomContentService.updateBomContent(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteBomContentById(@PathVariable id: Long): BaseResponse<String> {
        val data = bomContentService.deleteBomContentById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllBomContent(): BaseResponse<List<BomContentDto>> {
        val data = bomContentService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getBomContentById(@PathVariable id: Long): BaseResponse<BomContentDto> {
        val data = bomContentService.getById(id)

        return BaseResponse.success(data)
    }
}
