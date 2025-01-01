package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateAddressRequest
import com.iarpi.erp.controller.control.request.UpdateAddressRequest
import com.iarpi.erp.repository.control.AddressRepository
import com.iarpi.erp.service.control.AddressService
import org.springframework.stereotype.Service

@Service
data class AddressServiceImpl(val addressRepository: AddressRepository) : AddressService {

    override fun createAddress(request: CreateAddressRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateAddress(request: UpdateAddressRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteAddressById(id: Long): String {
        TODO("Not yet implemented")
    }
}
