package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.CityEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CityRepository : JpaRepository<CityEntity, Long> {
}