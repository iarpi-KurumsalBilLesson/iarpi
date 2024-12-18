package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.model.entity.CountryEntity
import com.iarpi.erp.model.entity.CountryId
import com.iarpi.erp.model.entity.LanguageEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CountryRepository : JpaRepository<CountryEntity, CountryId> {

    fun findByComCode(comCode: CompanyEntity): Optional<CountryEntity>

}
