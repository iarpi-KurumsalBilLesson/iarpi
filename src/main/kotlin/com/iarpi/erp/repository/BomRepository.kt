package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.BomEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BomRepository : JpaRepository<BomEntity, Long> {

}
