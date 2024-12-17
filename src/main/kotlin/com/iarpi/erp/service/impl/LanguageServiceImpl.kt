package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.LanguageDto
import com.iarpi.erp.model.dto.convertToEntity
import com.iarpi.erp.model.entity.LanguageId
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.LanguageRepository
import com.iarpi.erp.service.CompanyService
import com.iarpi.erp.service.LanguageService
import org.springframework.stereotype.Service

@Service
class LanguageServiceImpl(
    var repository: LanguageRepository,
    var companyService: CompanyService
) : LanguageService {

    override fun createNewLanguage(language: LanguageDto): LanguageDto {
        if (repository.findById(LanguageId(language.comCode, language.lanCode)).isPresent) {
            throw AlreadyExistException(
                StringBuilder()
                    .append(language.comCode).append(" ")
                    .append(language.lanCode).toString()
            )
        }

        val companyEntity = companyService.getCompanyByComCode(language.comCode)
        val entity = language.convertToEntity(companyEntity)
        val record = repository.save(entity)
        return record.convertToDto()
    }

    override fun updateLanguage(language: LanguageDto): LanguageDto {
        val entity = repository.findById(LanguageId(language.comCode, language.lanCode)).orElseThrow() {
            NotFoundException(
                StringBuilder()
                    .append(language.comCode).append(",")
                    .append(language.lanCode).toString()
            )
        }

        entity.lanText = language.lanText
        val record = repository.save(entity)
        return record.convertToDto()
    }

    override fun deleteLanguage(language: LanguageDto): String {
        val id = LanguageId(language.comCode, language.lanCode)
        repository.findById(id).orElseThrow {
            NotFoundException(
                StringBuilder()
                    .append(language.comCode).append(",")
                    .append(language.lanCode).toString()
            )
        }

        repository.deleteById(id)

        return "Record was deleted"
    }

    override fun getAll(): List<LanguageDto> {
        return repository.findAll().map { item -> item.convertToDto() }
    }

    override fun getByLanCode(lanCode: String): LanguageDto {
        TODO("Not yet implemented")
    }

    override fun getByComCode(comCode: String): LanguageDto {
        val companyEntity = companyService.getCompanyByComCode(comCode).convertToEntity()
        val entity = repository.findByComCode(companyEntity).orElseThrow() {
            NotFoundException(String.format("%d", comCode))
        }

        return entity.convertToDto()
    }
}
