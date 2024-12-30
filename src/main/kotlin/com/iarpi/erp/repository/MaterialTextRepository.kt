package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.MaterialTextEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MaterialTextRepository : JpaRepository<MaterialTextEntity, Long> {

    fun findByMaterialHead_Id(id: Long): MaterialTextEntity

}
