package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.OperationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OperationRepository : JpaRepository<OperationEntity, Long> {

}
