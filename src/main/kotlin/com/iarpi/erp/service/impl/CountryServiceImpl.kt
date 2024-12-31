package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCountryRequest
import com.iarpi.erp.controller.request.UpdateCountryRequest
import com.iarpi.erp.repository.CountryRepository
import com.iarpi.erp.service.CountryService
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
