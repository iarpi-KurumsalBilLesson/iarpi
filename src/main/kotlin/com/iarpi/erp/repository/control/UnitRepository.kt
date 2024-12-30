package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.UnitEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UnitRepository : JpaRepository<UnitEntity, Long> {

}
