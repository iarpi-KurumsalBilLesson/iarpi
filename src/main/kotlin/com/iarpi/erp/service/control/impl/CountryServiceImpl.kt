package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.CountryDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CountryRepository
import com.iarpi.erp.service.control.CountryService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CountryServiceImpl(
    private val countryRepository: CountryRepository
) : CountryService {

    override fun getAll(): List<CountryDto> {
        return countryRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): CountryDto {
        return countryRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
}
