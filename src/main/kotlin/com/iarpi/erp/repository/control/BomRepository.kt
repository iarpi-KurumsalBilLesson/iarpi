package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.BomEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BomRepository : JpaRepository<BomEntity, Long> {
}