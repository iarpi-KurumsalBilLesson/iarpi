package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.WorkCenterEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkCenterRepository : JpaRepository<WorkCenterEntity, Long>