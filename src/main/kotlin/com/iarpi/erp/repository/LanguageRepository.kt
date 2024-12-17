package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.model.entity.LanguageEntity
import com.iarpi.erp.model.entity.LanguageId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository : JpaRepository<LanguageEntity, LanguageId> {

    fun findByComCode(comCode: CompanyEntity): Optional<LanguageEntity>
}
