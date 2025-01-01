package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.RotOprContentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RotOprContentRepository : JpaRepository<RotOprContentEntity, Long> {
}