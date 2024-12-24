package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.CityEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CityRepository : JpaRepository<CityEntity, Long> {

    fun findByCityCode(cityCode: String): Optional<CityEntity>

}
