package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.BomHeadEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BomHeadRepository : JpaRepository<BomHeadEntity, Long> {

    fun findByDocNumAndCompany_Id(comNumber: String, companyId: Long): Optional<BomHeadEntity>

}