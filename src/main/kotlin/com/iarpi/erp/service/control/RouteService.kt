package com.iarpi.erp.service.control

import com.iarpi.erp.controller.control.request.CreateRouteRequest
import com.iarpi.erp.controller.control.request.UpdateRouteRequest
import com.iarpi.erp.model.dto.control.RouteDto

interface RouteService {
    fun createRoute(request: CreateRouteRequest): RouteDto
    fun updateRoute(id: Long, request: UpdateRouteRequest): RouteDto
    fun deleteRouteById(id: Long): String
    fun getAll(): List<RouteDto>
    fun getById(id: Long): RouteDto
}
