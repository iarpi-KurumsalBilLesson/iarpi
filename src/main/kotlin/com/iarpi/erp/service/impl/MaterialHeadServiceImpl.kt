package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateNewMaterialHeadRequest
import com.iarpi.erp.controller.request.UpdateMaterialHeadRequest
import com.iarpi.erp.model.dto.MaterialDto
import com.iarpi.erp.model.entity.MaterialHeadEntity
import com.iarpi.erp.model.entity.MaterialTextEntity
import com.iarpi.erp.model.entity.control.convertToDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.service.*
import com.iarpi.erp.service.control.*
import org.springframework.stereotype.Service

@Service
class MaterialHeadServiceImpl(
    val materialHeadRepository: MaterialHeadRepository,
    val unitService: UnitService,
    val companyService: CompanyService,
    val materialService: MaterialService,
    val bomService: BomService,
    val routeService: RouteService,
    val languageService: LanguageService,
) : MaterialHeadService {

    override fun createNewHeadMaterial(request: CreateNewMaterialHeadRequest): MaterialDto {
        val entity = this.createMaterialHeadEntity(request)
        val materialHeadDto = materialHeadRepository.save(entity).convertToDto();

        //todo: burada head ve text entitylerini bir arada kaydetmesi gerekir
        return MaterialDto(materialHeadDto, null) //TODO: burada text bilgileri gelecek mi ?
    }

    override fun updateMaterialHead(id: Long, request: UpdateMaterialHeadRequest): MaterialDto {
        val entity = materialHeadRepository.findById(id).orElseThrow { NotFoundException(id.toString()) }

        createMaterialHeadEntityForUpdate(entity, request)
        val materialHeadDto = materialHeadRepository.save(entity).convertToDto()

        return MaterialDto(materialHeadDto, null)
    }

    override fun deleteById(id: Long): String {
        materialHeadRepository.deleteById(id);

        return "Record was deleted"
    }

    override fun getAll(): List<MaterialDto> {
        val headDtos = materialHeadRepository.findAll().map { item -> item.convertToDto() }

        return headDtos.map { item -> MaterialDto(item, null) }
    }

    override fun getById(id: Long): MaterialDto {
        val entity = materialHeadRepository.findById(id)
            .orElseThrow { NotFoundException(id.toString()) }

        return MaterialDto(entity.convertToDto(), null)
    }

    private fun createMaterialHeadEntity(request: CreateNewMaterialHeadRequest): MaterialHeadEntity {

        val stUnitEntity = unitService.findById(request.stUnitId)
        val companyEntity = companyService.findById(request.companyId)
        val materialEntity = materialService.findById(request.materialId)
        val nwUnitEntity = unitService.findById(request.nwUnitId)
        val bwUnitEntity = unitService.findById(request.bwUnitId)
        val bomDocTypeEntity = bomService.findById(request.bomDocTypeId)
        val rotDocTypeEntity = routeService.findById(request.rotDocTypeId)
        val languageEntity = languageService.findById(request.rotDocTypeId)


        val materialHeadEntity = MaterialHeadEntity(
            null,
            request.docNumber,
            request.matDocFrom,
            request.matDocUntil,
            request.supplyType,
            request.netWeight,
            request.brutWeight,
            request.isBom,
            request.bomDocNumber,
            request.isRoute,
            request.rotDocNum,
            request.isDeleted,
            request.isPassive,
            stUnitEntity,
            companyEntity,
            materialEntity,
            nwUnitEntity,
            bwUnitEntity,
            bomDocTypeEntity,
            rotDocTypeEntity,
            null
        )

        val materialTextEntity = MaterialTextEntity(
            null,
            request.docNumber,
            request.matDocFrom,
            request.matDocUntil,
            request.matsText,
            request.matlText,
            companyEntity,
            materialEntity,
            languageEntity,
            materialHeadEntity
        )

        materialHeadEntity.materialText = materialTextEntity

        return materialHeadEntity
    }

    private fun createMaterialHeadEntityForUpdate(
        materialEntity: MaterialHeadEntity,
        request: UpdateMaterialHeadRequest
    ): MaterialHeadEntity {

        val nwUnitEntity = unitService.findById(request.nwUnitId)
        val bwUnitEntity = unitService.findById(request.bwUnitId)
        val bomDocTypeEntity = bomService.findById(request.bomDocTypeId)
        val rotDocTypeEntity = routeService.findById(request.rotDocTypeId)

        materialEntity.supplyType = request.supplyType
        materialEntity.netWeight = request.netWeight
        materialEntity.brutWeight = request.brutWeight
        materialEntity.isBom = request.isBom
        materialEntity.bomDocNum = request.bomDocNumber
        materialEntity.isRoute = request.isRoute
        materialEntity.rotDocNum = request.rotDocNum
        materialEntity.isDeleted = request.isDeleted
        materialEntity.isPassive = request.isPassive
        materialEntity.nwUnit = nwUnitEntity
        materialEntity.bwUnit = bwUnitEntity
        materialEntity.bomDocType = bomDocTypeEntity
        materialEntity.rotDocType = rotDocTypeEntity

        return materialEntity

    }
}


