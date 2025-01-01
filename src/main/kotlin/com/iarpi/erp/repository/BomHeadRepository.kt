package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.BomHeadEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BomHeadRepository : JpaRepository<BomHeadEntity, Long> {
}