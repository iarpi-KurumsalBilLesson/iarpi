package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateNewCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest
import com.iarpi.erp.model.dto.control.CompanyDto
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.service.control.CompanyService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CompanyServiceImpl(
    private val companyRepository: CompanyRepository
) : CompanyService {

    @Transactional
    override fun createCompany(request: CreateNewCompanyRequest): CompanyDto {
        val company = CompanyEntity(
            id = null,
            comCode = request.comCode,
            comText = request.comText,
            addressEntity = null
        )
        return companyRepository.save(company).convertToDto()
    }

    @Transactional
    override fun updateCompany(id: Long, request: UpdateCompanyRequest): CompanyDto {
        val company = companyRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }

        company.comText = request.comText

        return companyRepository.save(company).convertToDto()
    }

    @Transactional
    override fun deleteCompanyById(id: Long): String {
        if (!companyRepository.existsById(id)) {
            throw NotFoundException(id.toString())
        }

        companyRepository.deleteById(id)
        return "Company deleted successfully"
    }

    override fun getAll(): List<CompanyDto> {
        return companyRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): CompanyDto {
        return companyRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }
}
