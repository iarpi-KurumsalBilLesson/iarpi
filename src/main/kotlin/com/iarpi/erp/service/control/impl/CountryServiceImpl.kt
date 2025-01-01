package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateCountryRequest
import com.iarpi.erp.controller.control.request.UpdateCountryRequest
import com.iarpi.erp.repository.control.CountryRepository
import com.iarpi.erp.service.control.CountryService
import org.springframework.stereotype.Service

@Service
data class CountryServiceImpl(val countryRepository: CountryRepository) : CountryService {

    override fun createCountry(request: CreateCountryRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateCountry(request: UpdateCountryRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteCountryById(id: Long): String {
        TODO("Not yet implemented")
    }


}
