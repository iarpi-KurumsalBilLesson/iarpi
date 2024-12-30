package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateItemRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.controller.response.UpdateItemRequest
import com.iarpi.erp.service.ItemService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/test")
class TestController(val itemService: ItemService) {

    @PostMapping
    fun createNewItem(@RequestBody request: CreateItemRequest): BaseResponse<*> {
        val data = itemService.createNewItem(request)

        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun updateItem(@PathVariable id: Long, @RequestBody request: UpdateItemRequest): BaseResponse<*> {
        val data = itemService.updateItem(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteItemById(@PathVariable id: Long): BaseResponse<*> {
        val data = itemService.deleteItemById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllItem(): BaseResponse<*> {
        val data = itemService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getItemById(@PathVariable id: Long): BaseResponse<*> {
        val data = itemService.getById(id)

        return BaseResponse.success(data)
    }
}