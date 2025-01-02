package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CostCenterHeadEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CostCenterHeadRepository : JpaRepository<CostCenterHeadEntity, Long> {

    fun findByCompany_IdAndDocNum(companyId: Long, docNum: String): Optional<CostCenterHeadEntity>
}