package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.BomContentEntity
import org.springframework.data.jpa.repository.JpaRepository


interface BomContentRepository : JpaRepository<BomContentEntity, Long> {
}