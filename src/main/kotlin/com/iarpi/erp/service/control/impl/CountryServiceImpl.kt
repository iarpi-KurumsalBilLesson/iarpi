package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.CountryDto
import com.iarpi.erp.model.entity.control.CountryEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CountryRepository
import com.iarpi.erp.service.control.CompanyService
import com.iarpi.erp.service.control.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(var repository: CountryRepository, var companyService: CompanyService) : CountryService {

    override fun getAll(): List<CountryDto> {
        return repository.findAll().map { item ->
            item.convertToDto()
        }
    }

    override fun getAllEntity(): List<CountryEntity> {
        return repository.findAll()
    }

    override fun getByCountryCode(countryCode: String): CountryDto {
        val entity = repository.findByCountryCode(countryCode).orElseThrow {
            NotFoundException(countryCode)
        }

        return entity.convertToDto()
    }

    override fun getById(id: Long): CountryDto {
        val entity = repository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        return entity.convertToDto()
    }

    /*override fun getByComCode(comCode: String): CountryDto {
        val companyEntity = companyService.getCompanyByComCode(comCode).convertToEntity()
        val entity = repository.findByComCode(companyEntity).orElseThrow() {
            NotFoundException(String.format("%d", comCode))
        }

        return entity.convertToDto()
    }*/
}