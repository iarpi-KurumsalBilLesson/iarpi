package com.iarpi.erp.controller

import com.iarpi.erp.controller.request.CreateCompanyRequest
import com.iarpi.erp.controller.request.UpdateCompanyRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.service.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/company")
data class CompanyController(val companyService: CompanyService,)
{
    @PostMapping
    fun createNewCompany(@RequestBody request: CreateCompanyRequest): BaseResponse<*> {
        val data = companyService.createCompany(request)

        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Long, @RequestBody request: UpdateCompanyRequest): BaseResponse<*> {
        val data = companyService.updateCompany(request)
        return BaseResponse.success(data)

    }

    @DeleteMapping("/{id}")
    fun deleteCompanyById(@PathVariable id: Long): BaseResponse<*> {
        val data = companyService.deleteCompanyById(id)

        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllCompany(): BaseResponse<*> {
        val data = companyService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getCompanyById(@PathVariable id: Long): BaseResponse<*> {
        val data = companyService.getById(id)

        return BaseResponse.success(data)
    }
}
