package com.iarpi.erp.service

import com.iarpi.erp.model.dto.CompanyDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(var companyRepository: CompanyRepository) : CompanyService {

    override fun createNewCompany(companyDto: CompanyDto): CompanyDto {
        if (companyRepository.findById(companyDto.comCode).isPresent) {
            throw AlreadyExistException(companyDto.comCode)

        }

        val entity = companyDto.convertToEntity()
        val record = companyRepository.save(entity)

        return record.convertToDto()
    }

    override fun deleteCompanyWithComCode(comCode: String): String {
        companyRepository.deleteById(comCode)
        return String.format("Record was deleted by %S id", comCode)
    }

    override fun updateComTextWithComCode(companyDto: CompanyDto): CompanyDto {
        val entity = companyRepository.findById(companyDto.comCode)
            .orElseThrow { NotFoundException(companyDto.comCode) }

        entity.comText = companyDto.comText
        val record = companyRepository.save(entity)
        return record.convertToDto()
    }

    override fun getCompanyByComCode(comCode: String): CompanyDto {
        val company = companyRepository.findById(comCode).orElseThrow()
        { NotFoundException(comCode) }

        return company.convertToDto()
    }

    override fun getAll(): List<CompanyDto> {
        return companyRepository.findAll().map { item -> item.convertToDto() }
    }
}