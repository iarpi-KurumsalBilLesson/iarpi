package com.iarpi.erp.repository

import com.iarpi.erp.model.entity.ItemEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ItemRepository : JpaRepository<ItemEntity, Long>{

}
