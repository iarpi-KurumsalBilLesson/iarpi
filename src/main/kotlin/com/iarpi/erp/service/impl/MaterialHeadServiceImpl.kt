package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.controller.request.applyUpdatesTo
import com.iarpi.erp.controller.request.convertToEntity
import com.iarpi.erp.model.dto.MaterialHeadDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.repository.MaterialTextRepository
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.LanguageRepository
import com.iarpi.erp.repository.control.MaterialRepository
import com.iarpi.erp.repository.control.UnitRepository
import com.iarpi.erp.service.MaterialHeadService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MaterialHeadServiceImpl(
    private val materialHeadRepository: MaterialHeadRepository,
    private val materialRepository: MaterialRepository,
    private val companyRepository: CompanyRepository,
    private val languageRepository: LanguageRepository,
    private val unitRepository: UnitRepository,
    private val materialTextRepository: MaterialTextRepository,
) : MaterialHeadService {

    //todo: burada material oluştuğunda otomatikman bom ve rot oluşmasını sağla, bunu yaparken boolean değerlerin önemi var
    @Transactional
    override fun createNewMaterialHead(request: CreateMaterialHeadRequest): MaterialHeadDto {
        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException("request.companyId : "+request.companyId.toString()) }
        val material = materialRepository.findById(request.materialId)
            .orElseThrow { NotFoundException("request.materialId : "+request.materialId.toString()) }
//        val language = languageRepository.findById(request.languageId)
//            .orElseThrow { NotFoundException(request.languageId.toString()) }
        val stockUnit = unitRepository.findById(request.stockUnitId)
            .orElseThrow { NotFoundException("request.stockUnitId : "+request.stockUnitId.toString()) }

        val netWeightUnit = unitRepository.findById(request.newWeightId)
            .orElseThrow { NotFoundException("request.newWeightId : "+request.newWeightId.toString()) }
        val brutWeightUnit = unitRepository.findById(request.brutWeightId)
            .orElseThrow { NotFoundException("request.brutWeightId : "+request.brutWeightId.toString()) }

        val entity = request.convertToEntity(company, material, stockUnit, netWeightUnit, brutWeightUnit);

        return materialHeadRepository.save(entity).convertToDto();
    }

    @Transactional
    override fun updateMaterialHead(id : Long,request: UpdateMaterialHeadRequest): MaterialHeadDto {
        val materialHeadEntity = materialHeadRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }
        val materialTextEntity = materialTextRepository.findByMaterialHead_Id(id).orElseThrow { NotFoundException(id.toString()) }

        materialTextEntity.shortText = request.shortText
        materialTextEntity.longText = request.longText
        val updatedEntity = request.applyUpdatesTo(materialHeadEntity, materialTextEntity)

        return materialHeadRepository.save(updatedEntity).convertToDto()
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
        return materialHeadRepository.findAll().map { entity -> entity.convertToDto() }
    }

    override fun getById(id: Long): MaterialHeadDto {
        return materialHeadRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }
            .convertToDto()
    }

    private fun materialMatDocCheck(request: CreateMaterialHeadRequest) {
        if (materialHeadRepository.findByDocNumAndCompanyId(request.matDocNumber,request.companyId).isPresent()){
            throw AlreadyExistException(request.matDocNumber + " is already exist.")
        }
    }
}