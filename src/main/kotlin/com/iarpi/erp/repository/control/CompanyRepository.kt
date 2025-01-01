package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CompanyRepository : JpaRepository<CompanyEntity, Long>{
}