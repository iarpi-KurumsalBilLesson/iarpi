package com.iarpi.erp.repository.control

import com.iarpi.erp.model.entity.control.CityEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface CityRepository : JpaRepository<CityEntity, Long> {

    fun findByCityCode(cityCode: String): Optional<CityEntity>

}
