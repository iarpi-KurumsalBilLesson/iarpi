package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CountryEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CountryRepository : JpaRepository<CountryEntity, Long> {

    fun findByCountryCode(countryCode: String): Optional<CountryEntity>

}
