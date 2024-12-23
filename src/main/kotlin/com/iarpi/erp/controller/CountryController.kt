package com.iarpi.erp.controller

import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.CountryDto
import com.iarpi.erp.model.entity.CityEntity
import com.iarpi.erp.model.entity.CountryEntity
import com.iarpi.erp.service.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController(val service: CountryService) {

    @GetMapping("/{countryCode}")
    fun getByCountryCode(@PathVariable countryCode: String): BaseResponse<CountryDto> {
        val upperComCode = countryCode.uppercase()
        val response = service.getByCountryCode(upperComCode)

        return BaseResponse.success(response)
    }

    @GetMapping()
    fun getAll(): BaseCollectionResponse<CountryDto> {
        val response = service.getAll()

        return BaseCollectionResponse.success(response)
    }
}