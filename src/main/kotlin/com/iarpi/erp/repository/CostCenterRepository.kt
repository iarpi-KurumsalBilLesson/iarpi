package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.control.CostCenterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CostCenterRepository : JpaRepository<CostCenterEntity, Long>{
}