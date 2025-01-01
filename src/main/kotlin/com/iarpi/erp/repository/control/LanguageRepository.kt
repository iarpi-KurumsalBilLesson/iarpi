package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.LanguageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LanguageRepository : JpaRepository<LanguageEntity, Long>{
}