package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.controller.request.UpdateCompanyRequest


interface CompanyService {
    fun createCompany(request: CreateCompanyRequest)
    fun updateCompany(request: UpdateCompanyRequest)
    fun deleteCompanyById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
