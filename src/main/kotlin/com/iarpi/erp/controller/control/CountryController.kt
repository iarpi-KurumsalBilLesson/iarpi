package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/country")
data class CountryController(val countryService: CountryService) {


    @GetMapping
    fun getAllCountry(): BaseResponse<*> {
        val data = countryService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getCountryById(@PathVariable id: Long): BaseResponse<*> {
        val data = countryService.getById(id)

        return BaseResponse.success(data)
    }
}
