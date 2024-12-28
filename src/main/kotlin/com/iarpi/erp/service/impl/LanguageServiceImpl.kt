package com.iarpi.erp.service.impl

import com.iarpi.erp.model.dto.control.LanguageDto
import com.iarpi.erp.model.entity.LanguageEntity
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.LanguageRepository
import com.iarpi.erp.service.LanguageService
import org.springframework.stereotype.Service

@Service
class LanguageServiceImpl(
    var repository: LanguageRepository,
) : LanguageService {

    override fun getAll(): List<LanguageDto> {
        return repository.findAll().map { item -> item.convertToDto() }
    }

    override fun getByLanCode(lanCode: String): LanguageDto {
        val entity = repository.findByLanCode(lanCode).orElseThrow {
            NotFoundException(lanCode)
        }

        return entity.convertToDto()
    }

    override fun findById(id: Long): LanguageEntity {
        return repository.findById(id).orElseThrow{NotFoundException(id.toString())}
    }
}
