package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.WorkCenterTextEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WorkCenterTextRepository : JpaRepository<WorkCenterTextEntity, Long> {
}