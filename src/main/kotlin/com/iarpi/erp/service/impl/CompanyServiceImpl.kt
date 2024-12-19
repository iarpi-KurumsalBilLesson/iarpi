package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.CompanyDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CompanyRepository
import com.iarpi.erp.service.CompanyService
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
                .orElseThrow { NotFoundException(companyDto.comCode) }
        } ?: throw NotFoundException(companyDto.comCode) //burayı sonra degistirebilirsin

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

    override fun getByComCode(comCode: String): CompanyDto {
        val entity = companyRepository.findByComCode(comCode).orElseThrow { throw NotFoundException(comCode) }

        return entity.convertToDto() // id verilmeli mi ?
    }
}