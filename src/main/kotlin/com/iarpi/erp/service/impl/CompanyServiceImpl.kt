package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.controller.request.UpdateCompanyRequest
import com.iarpi.erp.repository.CompanyRepository
import com.iarpi.erp.service.CompanyService
import org.springframework.stereotype.Service

@Service
data class CompanyServiceImpl(val companyRepository: CompanyRepository) : CompanyService {

    override fun createCompany(request: CreateCompanyRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateCompany(request: UpdateCompanyRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteCompanyById(id: Long): String {
        TODO("Not yet implemented")
    }


}
