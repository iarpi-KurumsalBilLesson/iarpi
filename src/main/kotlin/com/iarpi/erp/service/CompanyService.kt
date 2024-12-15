package com.iarpi.erp.service

import com.iarpi.erp.model.dto.Company
import com.iarpi.erp.model.entity.CompanyEntity

interface CompanyService {

    fun createNewCompany(company: Company): CompanyEntity
    fun deleteCompanyWithComCode(comCode: String): String

    fun updateComTextWithComCode(company: Company): CompanyEntity
    //fun findCompanyWithComCode(); TODO : not implemented
}
