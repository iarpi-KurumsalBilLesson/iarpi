package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.CountryDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.CountryId
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CountryRepository
import com.iarpi.erp.service.CompanyService
import com.iarpi.erp.service.CountryService
import org.springframework.stereotype.Service

@Service
class CountryServiceImpl(var repository: CountryRepository, var companyService: CompanyService) : CountryService {
    override fun createNewCountry(country: CountryDto): CountryDto {
        if (repository.findById(CountryId(country.comCode, country.countryCode)).isPresent) {
            throw AlreadyExistException(
                StringBuilder()
                    .append(country.comCode).append(" ")
                    .append(country.countryCode).toString()
            )
        }

        val companyEntity = companyService.getCompanyByComCode(country.comCode)
        val entity = country.convertToEntity(companyEntity)
        val record = repository.save(entity)
        return record.convertToDto()
    }

    override fun updateCountry(country: CountryDto): CountryDto {
        val entity = repository.findById(CountryId(country.comCode, country.countryCode)).orElseThrow() {
            NotFoundException(
                StringBuilder()
                    .append(country.comCode).append(",")
                    .append(country.countryCode).toString()
            )
        }

        entity.countryText = country.countryText
        val record = repository.save(entity)
        return record.convertToDto()
    }

    override fun deleteCountry(country: CountryDto): String {
        val id = CountryId(country.comCode, country.countryCode)
        repository.findById(id).orElseThrow {
            NotFoundException(
                StringBuilder()
                    .append(country.comCode).append(",")
                    .append(country.countryCode).toString()
            )
        }

        repository.deleteById(id)

        return "Record was deleted"
    }

    override fun getAll(): List<CountryDto> {
        return repository.findAll().map { item -> item.convertToDto() }

    }

    override fun getByCountryCode(countryCode: String): CountryDto {
        TODO("Not yet implemented")
    }

    override fun getByComCode(comCode: String): CountryDto {
        val companyEntity = companyService.getCompanyByComCode(comCode).convertToEntity()
        val entity = repository.findByComCode(companyEntity).orElseThrow() {
            NotFoundException(String.format("%d", comCode))
        }

        return entity.convertToDto()
    }
}