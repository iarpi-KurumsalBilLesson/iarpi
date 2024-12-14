package com.iarpi.erp.service

import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.repository.CompanyRepository
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl (var companyRepository: CompanyRepository): CompanyService{

    override fun createNewCompany() : CompanyEntity{
        val company = CompanyEntity("TEST","trying with code 01")
        return companyRepository.save(company)
    }

    override fun deleteCompanyWithComCode() {
        TODO("Not yet implemented")
    }

    override fun findCompanyWithComCode() {
        TODO("Not yet implemented")
    }

    override fun updateComTextWithComCode() {
        TODO("Not yet implemented")
    }
}