package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CityDto
import com.iarpi.erp.service.control.CityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cities")
class CityController(
    private val cityService: CityService
) {
    @GetMapping
    fun getAllCity(): BaseResponse<List<CityDto>> {
        val cities = cityService.getAll()
        return BaseResponse.success(cities)
    }

    @GetMapping("/{id}")
    fun getCityById(@PathVariable id: Long): BaseResponse<CityDto> {
        val city = cityService.getById(id)
        return BaseResponse.success(city)
    }
}
