package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.MaterialEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MaterialRepository : JpaRepository<MaterialEntity, Long> {

}
