package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateRouteRequest
import com.iarpi.erp.controller.request.UpdateRouteRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.RouteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/route")
data class RouteController(val routeService: RouteService)
{
    @PostMapping
    fun createNewRoute(@RequestBody request: CreateRouteRequest): BaseResponse<*> {
        val data = routeService.createRoute(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateRoute(@PathVariable id: Long, @RequestBody request: UpdateRouteRequest): BaseResponse<*> {
        val data = routeService.updateRoute(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteRouteById(@PathVariable id: Long): BaseResponse<*> {
        val data = routeService.deleteRouteById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllRoute(): BaseResponse<*> {
        val data = routeService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getRouteById(@PathVariable id: Long): BaseResponse<*> {
        val data = routeService.getById(id)

        return BaseResponse.success(data)
    }
}
