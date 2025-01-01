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
    @PostMapping
    fun createNewCountry(@RequestBody request: CreateCountryRequest): BaseResponse<*> {
        val data = countryService.createCountry(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCountry(@PathVariable id: Long, @RequestBody request: UpdateCountryRequest): BaseResponse<*> {
        val data = countryService.updateCountry(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteCountryById(@PathVariable id: Long): BaseResponse<*> {
        val data = countryService.deleteCountryById(id)

        return BaseResponse.success(data)
    }

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
