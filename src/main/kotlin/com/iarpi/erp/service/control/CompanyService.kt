package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest


interface CompanyService {
    fun createCompany(request: CreateCompanyRequest)
    fun updateCompany(request: UpdateCompanyRequest)
    fun deleteCompanyById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
