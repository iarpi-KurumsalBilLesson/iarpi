package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateBomContentRequest
import com.iarpi.erp.controller.request.UpdateBomContentRequest
import com.iarpi.erp.controller.request.convertToEntity
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.BomContentRepository
import com.iarpi.erp.repository.BomHeadRepository
import com.iarpi.erp.repository.CostCenterHeadRepository
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.repository.control.BomRepository
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.service.BomContentService
import org.springframework.stereotype.Service

@Service
data class BomContentServiceImpl(
    val bomContentRepository: BomContentRepository,
    val companyRepository: CompanyRepository,
    val materialHeadRepository: MaterialHeadRepository,
    val costCenterHeadRepository: CostCenterHeadRepository,
    val bomHeadRepository: BomHeadRepository,
    val bomRepository: BomRepository
) : BomContentService {

    override fun createNewBomContent(request: CreateBomContentRequest): BomContentDto {
        val companyEntity = companyRepository.findById(request.companyId)
            .orElseThrow { throw NotFoundException("Şirket Bulunamadı " + request.companyId.toString()) }

        val materialHeadEntity = materialHeadRepository.findById(request.materialHeadId)
            .orElseThrow { throw NotFoundException("Urun Bulunamadı " + request.materialHeadId.toString()) }
        val costCenterEntity = costCenterHeadRepository.findById(request.costCenterId)
            .orElseThrow { throw NotFoundException("Maliyet Merkezi Bulunamadı " + request.costCenterId.toString()) }
        val bomHeadEntity = bomHeadRepository.findById(request.bomHeadId)
            .orElseThrow { throw NotFoundException("Urun Agacı Bulunamadı " + request.bomHeadId.toString()) }
        val bomEntity = bomRepository.findById(request.compBomTypeId)
            .orElseThrow { throw NotFoundException("Urun Agacı Çeşidi Bulunamadı " + request.compBomTypeId.toString()) }

        val bomContentEntity =
            request.convertToEntity(companyEntity, costCenterEntity, materialHeadEntity, bomHeadEntity, bomEntity)

        return bomContentRepository.save(bomContentEntity).convertToDto()
    }

    override fun updateBomContent(request: UpdateBomContentRequest) : BomContentDto{
        TODO("Not yet implemented")
    }

    override fun getAll(): List<BomContentDto> {
        return bomContentRepository.findAll().map { item -> item.convertToDto() }
    }

    override fun getById(id: Long): BomContentDto {
        return bomContentRepository.findById(id)
            .orElseThrow { throw NotFoundException("Urun Agacı Bulunamadı " + id.toString()) }.convertToDto()
    }

    override fun deleteBomContentById(id: Long): String {
        if (!bomContentRepository.existsById(id)) {
            throw NotFoundException("Urun Agacı Elementi Bulunamadı $id")
        }
        bomContentRepository.deleteById(id)
        return "Urun Agacı Elementi Basarılı şekilde silindi"
    }
}
