package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.LanguageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository : JpaRepository<LanguageEntity, Long> {

    fun findByLanCode(lanCode: String): Optional<LanguageEntity>
}
