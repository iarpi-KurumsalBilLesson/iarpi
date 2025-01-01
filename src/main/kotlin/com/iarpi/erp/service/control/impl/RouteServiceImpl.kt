package com.iarpi.erp.service.control.impl

import com.iarpi.erp.controller.control.request.CreateRouteRequest
import com.iarpi.erp.controller.control.request.UpdateRouteRequest
import com.iarpi.erp.repository.control.RouteRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.control.RouteService

@Service
data class RouteServiceImpl(val routeRepository: RouteRepository) : RouteService {

    override fun createRoute(request: CreateRouteRequest) {
        TODO("Not yet implemented")
    }

    override fun getAll() {
        TODO("Not yet implemented")
    }

    override fun getById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun updateRoute(request: UpdateRouteRequest) {
        TODO("Not yet implemented")
    }

    override fun deleteRouteById(id: Long): String {
        TODO("Not yet implemented")
    }

}
