package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateAddressRequest
import com.iarpi.erp.controller.request.CreateAddressRequest


interface AddressService {
    fun createAddress(request: CreateAddressRequest)
    fun updateAddress(request: UpdateAddressRequest)
    fun deleteAddressById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
