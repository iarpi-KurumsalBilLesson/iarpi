package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.CityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/city")
data class CityController(val cityService: CityService) {

    @GetMapping
    fun getAllCity(): BaseResponse<*> {
        val data = cityService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getCityById(@PathVariable id: Long): BaseResponse<*> {
        val data = cityService.getById(id)

        return BaseResponse.success(data)
    }
}
