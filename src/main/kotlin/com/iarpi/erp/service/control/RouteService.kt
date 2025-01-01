package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.UpdateRouteRequest
import com.iarpi.erp.controller.control.request.CreateRouteRequest


interface RouteService {
    fun createRoute(request: CreateRouteRequest)
    fun updateRoute(request: UpdateRouteRequest)
    fun deleteRouteById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
