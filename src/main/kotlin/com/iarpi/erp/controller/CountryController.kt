package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCountryRequest
import com.iarpi.erp.controller.request.UpdateCountryRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseCollectionResponse
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.CountryDto
import com.iarpi.erp.service.CountryService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/country")
class CountryController(val service: CountryService) {

    @PostMapping
    fun createNewCountry(@RequestBody request: CreateCountryRequest): BaseResponse<CountryDto> {
        val country = request.convertToDto()
        val response = service.createNewCountry(country)
        return BaseResponse.success(response)
    }

    @PutMapping
    fun updateCountry(@RequestBody request: UpdateCountryRequest): BaseResponse<CountryDto> {
        val country = request.convertToDto()
        val response = service.updateCountry(country)

        return BaseResponse.success(response)
    }

    @DeleteMapping()
    fun deleteCountry(@RequestBody country: CountryDto): BaseResponse<String> {
        val response = service.deleteCountry(country)

        return BaseResponse.success(response)
    }

    @GetMapping("/{comCode}")
    fun getByComCode(@PathVariable comCode: String): BaseResponse<CountryDto> {
        val upperComCode = comCode.uppercase()
        val response = service.getByComCode(upperComCode)

        return BaseResponse.success(response)
    }

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