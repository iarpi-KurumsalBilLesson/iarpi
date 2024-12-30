package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateItemRequest
import com.iarpi.erp.controller.response.UpdateItemRequest
import com.iarpi.erp.repository.ItemRepository
import com.iarpi.erp.service.ItemService
import org.springframework.stereotype.Service

@Service
class ItemServiceImpl(val itemRepository: ItemRepository) : ItemService {
    override fun createNewItem(request: CreateItemRequest) {
        TODO("Not yet implemented")
    }

    override fun updateItem(request: UpdateItemRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteItemById(id: Long) : String{
        return "record was deleted"
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }
}