package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.control.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<CountryEntity, Long>{
}