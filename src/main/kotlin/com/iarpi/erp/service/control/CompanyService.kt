package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.CompanyDto
import com.iarpi.erp.model.entity.control.CompanyEntity

interface CompanyService {

    fun createNewCompany(companyDto: CompanyDto): CompanyDto
    fun deleteById(comCode: Long): String
    fun updateComText(companyDto: CompanyDto): CompanyDto
    fun getAll(): List<CompanyDto>
    fun getByComCode(comCode: String): CompanyDto
    fun findById(id: Long) : CompanyEntity
    //fun findCompanyWithComCode(); TODO : not implemented
}
