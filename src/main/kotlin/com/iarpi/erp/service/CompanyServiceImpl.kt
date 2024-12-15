package com.iarpi.erp.service

import com.iarpi.erp.model.dto.Company
import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(var companyRepository: CompanyRepository) : CompanyService {

    override fun createNewCompany(company: Company): CompanyEntity {
        val entity = CompanyEntity(company.comCode, company.comText)
        return companyRepository.save(entity)
    }

    override fun deleteCompanyWithComCode(comCode: String): String {
        companyRepository.deleteById(comCode)
        return String().format("Record was deleted by %s id", comCode)
    }

    override fun updateComTextWithComCode(company: Company): CompanyEntity {
        val entity = companyRepository.findById(company.comCode)
            .orElseThrow { NotFoundException("Record not founded by ${company.comCode}") }

        entity.comText = company.comText
        return companyRepository.save(entity)

    }
}