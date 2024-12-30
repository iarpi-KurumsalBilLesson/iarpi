package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.CompanyDto
import com.iarpi.erp.model.dto.control.convertToEntity
import com.iarpi.erp.model.entity.control.CompanyEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.service.control.CompanyService
import org.springframework.stereotype.Service

@Service
class CompanyServiceImpl(var companyRepository: CompanyRepository) : CompanyService {

    override fun createNewCompany(companyDto: CompanyDto): CompanyDto {
        if (companyRepository.findByComCode(companyDto.comCode).isPresent) {
            throw AlreadyExistException(companyDto.comCode)
        }

        val entity = companyDto.convertToEntity()
        val record = companyRepository.save(entity)

        return record.convertToDto()
    }

    override fun updateComText(companyDto: CompanyDto): CompanyDto {
        val entity = companyDto.id?.let { id ->
            companyRepository.findById(id)
                .orElseThrow { NotFoundException(companyDto.id.toString()) }
        } ?: throw NotFoundException(companyDto.id.toString())

        entity.comText = companyDto.comText
        val record = companyRepository.save(entity)
        return record.convertToDto()
    }

    override fun deleteById(id: Long): String {
        companyRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
        companyRepository.deleteById(id)

        return String.format("Record was deleted by %S id", id)
    }

    override fun getAll(): List<CompanyDto> {
        return companyRepository.findAll().map { item -> item.convertToDto() }
    }

    override fun findById(id: Long): CompanyEntity {
        return companyRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
    }

    override fun getByComCode(comCode: String): CompanyDto {
        val entity = companyRepository.findByComCode(comCode).orElseThrow { throw NotFoundException(comCode) }

        return entity.convertToDto() // id verilmeli mi ?
    }
}