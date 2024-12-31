package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.control.WorkCenterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface WorkCenterRepository : JpaRepository<WorkCenterEntity,Long>{
}