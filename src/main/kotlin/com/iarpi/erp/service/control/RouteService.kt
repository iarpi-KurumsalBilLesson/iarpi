package com.iarpi.erp.service.control

import com.iarpi.erp.model.dto.control.RouteDto
import com.iarpi.erp.model.entity.control.RouteEntity

interface RouteService {
    fun getAll(): List<RouteDto>

    fun createNewRoute(routeDto: RouteDto): RouteDto
    fun updateRoute(id: Long, routeDto: RouteDto): RouteDto
    fun deleteRoute(id: Long): String
    fun getById(id: Long): RouteDto
    fun findById(id: Long) : RouteEntity

}
