package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateBomHeadRequest
import com.iarpi.erp.controller.request.UpdateBomHeadRequest
import com.iarpi.erp.controller.request.convertToEntity
import com.iarpi.erp.model.dto.BomContentDto
import com.iarpi.erp.model.dto.BomHeadDto
import com.iarpi.erp.model.entity.convertToDto
import com.iarpi.erp.model.exception.AlreadyExistException
import com.iarpi.erp.model.exception.NotFoundException
import com.iarpi.erp.repository.BomContentRepository
import com.iarpi.erp.repository.BomHeadRepository
import com.iarpi.erp.repository.MaterialHeadRepository
import com.iarpi.erp.repository.control.BomRepository
import com.iarpi.erp.repository.control.CompanyRepository
import com.iarpi.erp.repository.control.MaterialRepository
import com.iarpi.erp.service.BomHeadService
import org.springframework.stereotype.Service
import java.util.*

@Service
data class BomHeadServiceImpl(
    val bomHeadRepository: BomHeadRepository,
    val companyRepository: CompanyRepository,
    val materialHeadRepository: MaterialHeadRepository,
    val materialTypeRepository: MaterialRepository,
    val bomRepository: BomRepository,
    val bomContentRepository: BomContentRepository,
) : BomHeadService {

    override fun createNewBomHead(request: CreateBomHeadRequest): BomHeadDto {
        this.checkBomHead(request)

        val companyEntity = companyRepository.findById(request.companyId)
            .orElseThrow { throw NotFoundException("Şirket Bulunamadı " + request.companyId.toString()) }

        val materialHeadEntity = materialHeadRepository.findById(request.materialHeadId)
            .orElseThrow { throw NotFoundException("Urun Bulunamadı " + request.materialHeadId.toString()) }

        val materialTypeEntity = materialTypeRepository.findById(request.materialTypeId)
            .orElseThrow { throw NotFoundException("Urun Tipi Bulunamadı " + request.materialTypeId.toString()) }

        val bomTypeEntity = bomRepository.findById(request.bomTypeId)
            .orElseThrow { throw NotFoundException("Urun Agacı Tipi Bulunamadı " + request.bomTypeId.toString()) }


        val entity = request.convertToEntity(companyEntity, materialHeadEntity, materialTypeEntity, bomTypeEntity)

        return bomHeadRepository.save(entity).convertToDto()
    }

    private fun checkBomHead(request: CreateBomHeadRequest) {
        if (bomHeadRepository.findByDocNumAndCompany_Id(request.bomDocNumber, request.companyId).isPresent) {
            throw AlreadyExistException("Urun Agacı Kodu ${request.bomDocNumber} zaten kayıtlı")
        }
    }

    override fun getAllBomContentByHeadId(bomHeadId: Long): List<BomContentDto> {
        bomHeadRepository.findById(bomHeadId)
            .orElseThrow { throw NotFoundException("BomHead not found with id: $bomHeadId") }

        return bomContentRepository.findByBomHead_Id(bomHeadId).map { item -> item.convertToDto() }
    }

    override fun getAll(): List<BomHeadDto> {
        return bomHeadRepository.findAll().map { item -> item.convertToDto() }
    }

    override fun getById(id: Long): BomHeadDto {
        return bomHeadRepository.findById(id)
            .orElseThrow { throw NotFoundException("Verilen bilgilere gore BOM bulunamadı") }.convertToDto()
    }

    override fun updateBomHead(id: Long, request: UpdateBomHeadRequest): BomHeadDto {
        val entity = bomHeadRepository.findById(id)
            .orElseThrow { throw NotFoundException("Verilen bilgilere gore BOM bulunamadı") }

        entity.quantity = request.quantity

        return bomHeadRepository.save(entity).convertToDto()
    }

    override fun deleteBomHeadById(id: Long): String {
        if (!bomHeadRepository.existsById(id)) {
            throw NotFoundException("Bom not found with id: $id")
        }
        bomHeadRepository.deleteById(id)
        return "Bom deleted successfully"
    }
}
