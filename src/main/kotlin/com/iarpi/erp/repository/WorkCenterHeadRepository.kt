package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.WorkCenterHeadEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WorkCenterHeadRepository : JpaRepository<WorkCenterHeadEntity, Long>{
}