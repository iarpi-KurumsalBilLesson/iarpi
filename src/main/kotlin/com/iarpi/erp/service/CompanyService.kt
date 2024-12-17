package com.iarpi.erp.service

import com.iarpi.erp.model.dto.CompanyDto

interface CompanyService {

    fun createNewCompany(companyDto: CompanyDto): CompanyDto
    fun deleteCompanyWithComCode(comCode: String): String

    fun updateComTextWithComCode(companyDto: CompanyDto): CompanyDto
    fun getCompanyByComCode(comCode: String): CompanyDto
    fun getAll(): List<CompanyDto>
    //fun findCompanyWithComCode(); TODO : not implemented
}
