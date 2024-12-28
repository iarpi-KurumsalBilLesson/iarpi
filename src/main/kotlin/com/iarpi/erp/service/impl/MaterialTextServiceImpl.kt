package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.UpdateMaterialTextRequest
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.model.dto.MaterialTextDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialTextRepository
import com.iarpi.erp.service.MaterialTextService
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class MaterialTextServiceImpl(val materialTextRepository: MaterialTextRepository) : MaterialTextService {

    override fun getById(id: Long): MaterialTextDto {
        return materialTextRepository.findById(id).orElseThrow{NotFoundException(id.toString())}.convertToDto();
    }

    override fun updateMaterialHead(id: Long, request: UpdateMaterialTextRequest): MaterialTextDto {
        val entity = materialTextRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        entity.matltText = request.matlText
        entity.matsText = request.matsText
        return materialTextRepository.save(entity).convertToDto()
    }

    override fun deleteById(id: Long): String {
        materialTextRepository.deleteById(id)

        return "Record was deleted"
    }
}