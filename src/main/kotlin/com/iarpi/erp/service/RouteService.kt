package com.iarpi.erp.service

import com.iarpi.erp.controller.request.UpdateRouteRequest
import com.iarpi.erp.controller.request.CreateRouteRequest


interface RouteService {
    fun createRoute(request: CreateRouteRequest)
    fun updateRoute(request: UpdateRouteRequest)
    fun deleteRouteById(id: Long): String
    fun getAll()
    fun getById(id: Long)
}
