package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.OperationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OperationRepository : JpaRepository<OperationEntity, Long>{
}