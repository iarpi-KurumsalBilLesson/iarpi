package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.CompanyEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CompanyRepository : JpaRepository<CompanyEntity, Long> {

    fun findByComCode(comCode: String): Optional<CompanyEntity>
}