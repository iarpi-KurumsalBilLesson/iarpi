package com.iarpi.erp.service

import com.iarpi.erp.model.dto.CompanyDto

interface CompanyService {

    fun createNewCompany(companyDto: CompanyDto): CompanyDto
    fun deleteById(comCode: Long): String
    fun updateComText(companyDto: CompanyDto): CompanyDto
    fun getAll(): List<CompanyDto>
    fun getByComCode(comCode: String): CompanyDto
    //fun findCompanyWithComCode(); TODO : not implemented
}
