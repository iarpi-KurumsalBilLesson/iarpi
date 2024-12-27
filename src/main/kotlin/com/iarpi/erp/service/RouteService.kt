package com.iarpi.erp.service

import com.iarpi.erp.model.dto.RouteDto

interface RouteService {
    fun getAll(): List<RouteDto>

    fun createNewRoute(routeDto: RouteDto): RouteDto
    fun updateRoute(id: Long, routeDto: RouteDto): RouteDto
    fun deleteRoute(id: Long): String
    fun getById(id: Long): RouteDto

}
