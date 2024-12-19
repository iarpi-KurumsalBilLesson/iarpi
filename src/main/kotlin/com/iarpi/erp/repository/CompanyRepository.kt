package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CompanyRepository : JpaRepository<CompanyEntity, Long> {

    fun findByComCode(comCode : String) : Optional<CompanyEntity>
}