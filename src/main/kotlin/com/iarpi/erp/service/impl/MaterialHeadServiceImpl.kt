package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.model.dto.MaterialHeadDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.service.MaterialHeadService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MaterialHeadServiceImpl(
    private val materialHeadRepository: MaterialHeadRepository
) : MaterialHeadService {

    @Transactional
    override fun createNewMaterialHead(request: CreateMaterialHeadRequest): MaterialHeadDto {
        // TODO: Entity oluşturma ve dönüştürme işlemleri eklenecek
        throw NotImplementedError("Bu metod henüz implemente edilmedi")
    }

    @Transactional
    override fun updateMaterialHead(request: UpdateMaterialHeadRequest): MaterialHeadDto {
        // TODO: Güncelleme işlemleri eklenecek
        throw NotImplementedError("Bu metod henüz implemente edilmedi")
    }

    @Transactional
    override fun deleteMaterialHeadById(id: Long): String {
        if (!materialHeadRepository.existsById(id)) {
            throw NotFoundException("Material head not found with id: $id")
        }
        materialHeadRepository.deleteById(id)
        return "Material head deleted successfully"
    }

    override fun getAll(): List<MaterialHeadDto> {
        // TODO: Entity'den DTO'ya dönüştürme işlemleri eklenecek
        throw NotImplementedError("Bu metod henüz implemente edilmedi")
    }

    override fun getById(id: Long): MaterialHeadDto {
        // TODO: Entity'den DTO'ya dönüştürme işlemleri eklenecek
        throw NotImplementedError("Bu metod henüz implemente edilmedi")
    }
}