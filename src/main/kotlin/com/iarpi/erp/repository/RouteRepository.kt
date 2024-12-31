package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.control.RouteEntity
import org.springframework.data.jpa.repository.JpaRepository

interface RouteRepository : JpaRepository<RouteEntity, Long>{
}