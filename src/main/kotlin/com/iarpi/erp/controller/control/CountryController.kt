package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CountryDto
import com.iarpi.erp.service.control.CountryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/countries")
class CountryController(
    private val countryService: CountryService
) {
    @GetMapping
    fun getAllCountry(): BaseResponse<List<CountryDto>> {
        val countries = countryService.getAll()
        return BaseResponse.success(countries)
    }

    @GetMapping("/{id}")
    fun getCountryById(@PathVariable id: Long): BaseResponse<CountryDto> {
        val country = countryService.getById(id)
        return BaseResponse.success(country)
    }
}
