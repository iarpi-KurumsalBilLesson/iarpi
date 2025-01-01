package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateNewCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest
import com.iarpi.erp.model.dto.control.CompanyDto

interface CompanyService {
    fun createCompany(request: CreateNewCompanyRequest): CompanyDto
    fun updateCompany(id: Long, request: UpdateCompanyRequest): CompanyDto
    fun deleteCompanyById(id: Long): String
    fun getAll(): List<CompanyDto>
    fun getById(id: Long): CompanyDto
}
