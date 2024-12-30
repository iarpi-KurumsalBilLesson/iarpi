package com.iarpi.erp.service

import com.iarpi.erp.controller.request.CreateItemRequest
import com.iarpi.erp.controller.response.UpdateItemRequest

interface ItemService {

    fun createNewItem(request: CreateItemRequest)
    fun updateItem(request: UpdateItemRequest)
    fun deleteItemById(id: Long): String
    fun getAll()
    fun getById(id: Long)

}
