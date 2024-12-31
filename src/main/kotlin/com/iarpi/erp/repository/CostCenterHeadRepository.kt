package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CostCenterHeadEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CostCenterHeadRepository : JpaRepository<CostCenterHeadEntity, Long> {
}