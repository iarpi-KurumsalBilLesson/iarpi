package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateCountryRequest
import com.iarpi.erp.controller.control.request.UpdateCountryRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.control.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
data class CountryController(val countryService: CountryService)
{


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
