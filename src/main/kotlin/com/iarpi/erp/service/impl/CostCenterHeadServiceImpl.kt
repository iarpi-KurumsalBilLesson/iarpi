package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateCostCenterHeadRequest
import com.iarpi.erp.controller.request.UpdateCostCenterHeadRequest
import com.iarpi.erp.controller.request.applyUpdatesTo
import com.iarpi.erp.controller.request.convertToEntity
import com.iarpi.erp.model.dto.CostCenterHeadDto
import com.iarpi.erp.model.entity.convertToEntity
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.CostCenterHeadRepository
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.CostCenterRepository
import com.iarpi.erp.service.CostCenterHeadService
import org.springframework.stereotype.Service

@Service
class CostCenterHeadServiceImpl(
    val costCenterHeadRepository: CostCenterHeadRepository,
    val companyRepository: CompanyRepository,
    val costCenterRepository: CostCenterRepository
) : CostCenterHeadService {

    override fun createNewCostCenterHead(request: CreateCostCenterHeadRequest): CostCenterHeadDto {
        this.checkDocNumberByComCode(request.companyId,request.ccmDocNumber)

        val company = companyRepository.findById(request.companyId)
            .orElseThrow { NotFoundException("Şirket Bulunamadı : " + request.companyId.toString()) }
        val costCenter = costCenterRepository.findById(request.costCenterTypeId)
            .orElseThrow { NotFoundException("Cost Center Type Bulunamadı : " + request.costCenterTypeId.toString()) }


        val entity = request.convertToEntity(company, costCenter)

        if (request.baseCostCenterId != null) {
            val baseCostCenterEntity = costCenterHeadRepository.findById(request.baseCostCenterId)
                .orElseThrow { NotFoundException("Base Cost Center Bulunamadı : " + request.baseCostCenterId.toString()) }

            entity.apply { this.baseCostCenter = baseCostCenterEntity }
        }

        return costCenterHeadRepository.save(entity).convertToEntity()
    }

    override fun updateCostCenterHead(id: Long, request: UpdateCostCenterHeadRequest): CostCenterHeadDto {
        val entity =
            costCenterHeadRepository.findById(id).orElseThrow { NotFoundException("CotCenterId : " + id.toString()) }

        if (request.baseCostCenterId != null) {
            val baseCostCenterEntity = costCenterHeadRepository.findById(id)
                .orElseThrow { NotFoundException("CotCenterId : " + id.toString()) }
            request.applyUpdatesTo(entity, baseCostCenterEntity)

            return costCenterHeadRepository.save(entity).convertToEntity()
        }

        request.applyUpdatesTo(entity, null)

        return costCenterHeadRepository.save(entity).convertToEntity()
    }

    override fun getAll(): List<CostCenterHeadDto> {
        return costCenterHeadRepository.findAll().map { it.convertToEntity() }
    }

    override fun getById(id: Long): CostCenterHeadDto {
        val entity =
            costCenterHeadRepository.findById(id).orElseThrow { NotFoundException("CotCenterId : " + id.toString()) }

        return entity.convertToEntity()
    }

    override fun deleteCostCenterHeadById(id: Long): String {
        if (!costCenterHeadRepository.existsById(id)) {
            throw NotFoundException("İlgili maliyet merkezi bulunamadı $id")
        }
        costCenterHeadRepository.deleteById(id)
        return "Maliyet Merkezi silindi."
    }

    private fun checkDocNumberByComCode(companyId: Long, docNumber: String) {
        if (costCenterHeadRepository.findByCompany_IdAndDocNum(companyId, docNumber).isPresent) {
            throw AlreadyExistException("Doc Number $docNumber zaten kayıtlı")
        }
    }
}