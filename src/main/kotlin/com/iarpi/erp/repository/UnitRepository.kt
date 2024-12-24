package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.UnitEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UnitRepository : JpaRepository<UnitEntity, Long> {

}
