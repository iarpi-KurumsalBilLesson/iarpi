package com.iarpi.erp.controller.control

import com.iarpi.erp.controller.control.request.CreateNewCompanyRequest
import com.iarpi.erp.controller.control.request.UpdateCompanyRequest
import com.iarpi.erp.controller.response.BaseResponse
import com.iarpi.erp.model.dto.control.CompanyDto
import com.iarpi.erp.service.control.CompanyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/company")
class CompanyController(val companyService: CompanyService) {

    @PostMapping
    fun createNewCompany(@RequestBody request: CreateNewCompanyRequest): BaseResponse<CompanyDto> {
        val data = companyService.createCompany(request)
        return BaseResponse.success(data)
    }

    @PutMapping("/{id}")
    fun updateCompany(@PathVariable id: Long, @RequestBody request: UpdateCompanyRequest): BaseResponse<CompanyDto> {
        val data = companyService.updateCompany(id, request)
        return BaseResponse.success(data)
    }

    @DeleteMapping("/{id}")
    fun deleteCompanyById(@PathVariable id: Long): BaseResponse<String> {
        val data = companyService.deleteCompanyById(id)
        return BaseResponse.success(data)
    }

    @GetMapping
    fun getAllCompanies(): BaseResponse<List<CompanyDto>> {
        val data = companyService.getAll()
        return BaseResponse.success(data)
    }

    @GetMapping("/{id}")
    fun getCompanyById(@PathVariable id: Long): BaseResponse<CompanyDto> {
        val data = companyService.getById(id)
        return BaseResponse.success(data)
    }
}
