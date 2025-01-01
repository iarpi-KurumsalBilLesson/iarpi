package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.RotBomContentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RotBomContentRepository : JpaRepository<RotBomContentEntity, Long> {
}