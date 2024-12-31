package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.UpdateAddressRequest
import com.iarpi.erp.controller.request.CreateAddressRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.AddressService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/address")
data class AddressController(val addressService: AddressService)
{
    @PostMapping
    fun createNewAddress(@RequestBody request: CreateAddressRequest): BaseResponse<*> {
        val data = addressService.createAddress(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateAddress(@PathVariable id: Long, @RequestBody request: UpdateAddressRequest): BaseResponse<*> {
        val data = addressService.updateAddress(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteAddressById(@PathVariable id: Long): BaseResponse<*> {
        val data = addressService.deleteAddressById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllAddress(): BaseResponse<*> {
        val data = addressService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAddressById(@PathVariable id: Long): BaseResponse<*> {
        val data = addressService.getById(id)

        return BaseResponse.success(data)
    }
}
