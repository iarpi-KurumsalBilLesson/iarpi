package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CostCenterTextEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CostCenterTextRepository : JpaRepository<CostCenterTextEntity, Long> {
}