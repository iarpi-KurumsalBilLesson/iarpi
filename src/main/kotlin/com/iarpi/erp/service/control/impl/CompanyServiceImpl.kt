package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.service.control.CompanyService
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
