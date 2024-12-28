package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.AddressEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<AddressEntity, Long> {
}