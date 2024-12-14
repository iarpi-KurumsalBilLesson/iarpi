package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.model.entity.CompanyEntity
import com.iarpi.erp.service.CompanyService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/gen")
class GenController(val companyService: CompanyService) {

    @PostMapping()// todo: must be post
    fun createNewCompany(@RequestBody req: CreateCompanyRequest):CompanyEntity{
        return companyService.createNewCompany()
    }
}