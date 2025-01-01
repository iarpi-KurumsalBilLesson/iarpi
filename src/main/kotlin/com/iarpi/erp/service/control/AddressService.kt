package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateAddressRequest
import com.iarpi.erp.controller.control.request.UpdateAddressRequest


interface AddressService {
    fun createAddress(request: CreateAddressRequest)
    fun updateAddress(request: UpdateAddressRequest)
    fun deleteAddressById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
