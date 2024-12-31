package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.WorkCenterOprEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WorkCenterOprRepository : JpaRepository<WorkCenterOprEntity, Long>{
}