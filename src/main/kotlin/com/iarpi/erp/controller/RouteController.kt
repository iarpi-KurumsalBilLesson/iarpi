package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateNewRouteRequest
import com.iarpi.erp.controller.request.UpdateRouteRequest
import com.iarpi.erp.controller.request.convertToDto
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.RouteDto
import com.iarpi.erp.service.RouteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/route")
class RouteController(val routeService: RouteService) {

    @GetMapping()
    fun getRouteCodes(): BaseResponse<List<RouteDto>> {
        val data = routeService.getAll()

        return BaseResponse.success(data);
    }

    @GetMapping("/{id}")
    fun getRouteCodeById(@PathVariable id: Long): BaseResponse<RouteDto> {
        val data = routeService.getById(id)

        return BaseResponse.success(data);
    }

    @PostMapping
    fun createNewRoute(@RequestBody request: CreateNewRouteRequest): BaseResponse<RouteDto> {
        val record = routeService.createNewRoute(request.convertToDto())

        return BaseResponse.success(record)
    }

    @PutMapping("/{id}")
    fun updateRoute(@PathVariable id: Long, @RequestBody request: UpdateRouteRequest): BaseResponse<RouteDto> {
        val record = routeService.updateRoute(id, request.convertToDto())

        return BaseResponse.success(record)
    }

    @DeleteMapping("/{id}")
    fun getRouteCodes(@PathVariable id: Long): BaseResponse<String> {
        val data = routeService.deleteRoute(id)

        return BaseResponse.success(data);
    }
}