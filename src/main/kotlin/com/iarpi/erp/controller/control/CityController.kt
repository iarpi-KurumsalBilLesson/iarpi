package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CityDto
import com.iarpi.erp.service.control.CityService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/city")
class CityController(val service: CityService) {

    @GetMapping("/{cityCode}")
    fun getByCityCode(@PathVariable cityCode: String): BaseResponse<CityDto> {
        val upperComCode = cityCode.uppercase()
        val response = service.getByCityCode(upperComCode)

        return BaseResponse.success(response)
    }

    @GetMapping()
    fun getAll(): BaseCollectionResponse<CityDto> {
        val response = service.getAll()

        return BaseCollectionResponse.success(response)
    }
}