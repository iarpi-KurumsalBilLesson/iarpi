package com.iarpi.erp.service.control.impl

import com.iarpi.erp.model.dto.control.LanguageDto
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.control.LanguageRepository
import com.iarpi.erp.service.control.LanguageService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LanguageServiceImpl(
    private val languageRepository: LanguageRepository
) : LanguageService {

    override fun getAll(): List<LanguageDto> {
        return languageRepository.findAll().map { it.convertToDto() }
    }

    override fun getById(id: Long): LanguageDto {
        return languageRepository.findById(id)
            .orElseThrow { NotFoundException("Language not found with id: $id") }
            .convertToDto()
    }
}
