package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.MaterialHeadEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface MaterialHeadRepository : JpaRepository<MaterialHeadEntity, Long> {

    fun findByDocNumAndCompanyId(docNum: String, companyId: Long): Optional<MaterialHeadEntity>
    fun findByCompany_IdAndDocNum(companyId: Long, docNum: String): Optional<MaterialHeadEntity>

}