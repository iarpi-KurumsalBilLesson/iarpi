package com.iarpi.erp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/test")
class TestController {

    @GetMapping("/employees")
    fun getAllEmployees(): String = "bu bir iarpiCompany projesidir"
}