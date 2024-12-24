package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.LanguageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository : JpaRepository<LanguageEntity, Long> {

    fun findByLanCode(lanCode: String): Optional<LanguageEntity>
}
