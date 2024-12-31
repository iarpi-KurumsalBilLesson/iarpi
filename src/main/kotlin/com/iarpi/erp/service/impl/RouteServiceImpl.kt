package com.iarpi.erp.service.impl

import com.iarpi.erp.controller.request.CreateRouteRequest
import com.iarpi.erp.controller.request.UpdateRouteRequest
import com.iarpi.erp.repository.RouteRepository
import org.springframework.stereotype.Service
import com.iarpi.erp.service.RouteService

@Service
data class RouteServiceImpl(val routeRepository: RouteRepository) : RouteService{

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
